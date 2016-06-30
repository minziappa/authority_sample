package io.sample.service.impl;

import io.sample.bean.model.UserModel;
import io.sample.bean.para.login.LoginPara;
import io.sample.bean.para.user.UserDetailPara;
import io.sample.bean.para.user.UserPara;
import io.sample.dao.MasterDao;
import io.sample.dao.SlaveDao;
import io.sample.service.AbstractService;
import io.sample.service.LoginService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl extends AbstractService implements LoginService {

	final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private SqlSession masterDao;
	@Autowired
	private SqlSession slaveDao;

	/**
	 * 
	 * 
	 */
	public UserModel selectUser(String name) throws Exception {
	
		UserModel user = new UserModel();
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", name);
	
		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			user = slaveDao.getMapper(SlaveDao.class).selectUser(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
	
		return user;
	}

	/**
	 * 
	 * 
	 */
	@Override
	public List<UserModel> selectUserList() throws Exception {

		List<UserModel> userList = new ArrayList<UserModel>();

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			userList = slaveDao.getMapper(SlaveDao.class).selectUsersList();
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return userList;
	}

	/**
	 * 
	 */
	@Override
	public UserModel checkUserRegistered(LoginPara loginPara) throws Exception {

		UserModel user = this.selectUser(loginPara.getUserName());
		if(user == null) {
			logger.warn("There is no user.");
			return null;
		}

		// Check PWD
		if(!loginPara.getUserPwd().equals(user.getUserPwd())) {
			logger.warn("The password is not matched.");
			return null;
		}

		return user;
	}

	/**
	 * 
	 * 
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean insertUser(UserPara userPara) throws Exception {

		int intResult = 0;

		// If there is a user
		if(this.selectUser(userPara.getUserName()) == null) {
			return false;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userPara.getUserName());
		map.put("userPwd", userPara.getUserPwd());
		map.put("userStatus", userPara.getUserStatus());

		try {
			intResult = masterDao.getMapper(MasterDao.class).insertUser(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("insertSample error, userName={}", userPara.getUserName());
			return false;
		}

		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean deleteUser(UserPara userPara) throws Exception {
		int intResult = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userPara.getUserName());

		try {
			intResult = masterDao.getMapper(MasterDao.class).deleteUser(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("deleteUser error, userName={}", userPara.getUserName());
			return false;
		}

		return true;
	}

}