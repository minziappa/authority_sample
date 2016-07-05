package io.sample.service.impl;

import io.sample.bean.model.auth.AuthJoinUsersModel;
import io.sample.bean.model.auth.AuthModel;
import io.sample.bean.model.auth.UserAuthModel;
import io.sample.bean.para.auth.AuthPara;
import io.sample.bean.para.auth.UpdateUsersPara;
import io.sample.dao.MasterDao;
import io.sample.dao.SlaveDao;
import io.sample.service.AbstractService;
import io.sample.service.AuthService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl extends AbstractService implements AuthService {

	final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	private SqlSession masterDao;
	@Autowired
	private SqlSession slaveDao;
	@Autowired
	private SqlSession masterBatchDao;

	@Autowired
    private Configuration configuration;

	@Override
	public boolean checkAuth(String authority) throws Exception {
		AuthModel auth = this.selectAuth(authority);
		if(auth == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<AuthJoinUsersModel> selectAuthAndUsers(String authority) throws Exception {

		List<AuthJoinUsersModel> authJoinUsersList = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("authority", authority);

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			authJoinUsersList = slaveDao.getMapper(SlaveDao.class).selectAuthJoinUserMapList();
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return authJoinUsersList;
	}

	@Override
	public AuthModel selectAuth(String authority) throws Exception {

		AuthModel auth = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("authority", authority);

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			auth = slaveDao.getMapper(SlaveDao.class).selectAuth(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return auth;
	}

	private UserAuthModel selectUserAuth(int userId, int authorityId) throws Exception {

		UserAuthModel userAuth = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("authorityId", authorityId);

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			userAuth = slaveDao.getMapper(SlaveDao.class).selectUserAuth(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return userAuth;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean insertAuth(AuthPara authPara) throws Exception {

		int intResult = 0;

		if(this.checkAuth(authPara.getAuthority())) {
			logger.warn("There is a data.");
			return false;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("authority", authPara.getAuthority());

		try {
			intResult = masterDao.getMapper(MasterDao.class).insertAuth(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("insertSample error, userName={}", authPara.getAuthority());
			return false;
		}

		return true;
	}

	@Override
	public List<AuthModel> selectAuthList() throws Exception {

		List<AuthModel> authList = new ArrayList<AuthModel>();

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			authList = slaveDao.getMapper(SlaveDao.class).selectAuthList();
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return authList;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateUsers(UpdateUsersPara updateUsersPara) throws Exception{
		int intResult = 0;

		if(this.checkAuth(updateUsersPara.getAuthorityId())) {
			logger.warn("There is a data.");
			return false;
		}

		try {

			for(String userId : updateUsersPara.getUserIdAuth()) {

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userId", new Integer(userId));
				map.put("authorityId", new Integer(updateUsersPara.getAuthorityId()));

				masterBatchDao.getMapper(MasterDao.class).insertUserAuth(map);
			}

		} catch (Exception e) {
			logger.error("Exception error", e);
			throw e;
		}
		if(intResult < 1) {
			logger.error("insertSample error, userName={}", updateUsersPara.getAuthorityId());
			return false;
		}

		return true;
	}
}