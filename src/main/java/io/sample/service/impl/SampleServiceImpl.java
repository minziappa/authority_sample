package io.sample.service.impl;

import io.sample.bean.model.UsersModel;
import io.sample.bean.para.user.UserDetailPara;
import io.sample.bean.para.user.UserPara;
import io.sample.dao.MasterDao;
import io.sample.dao.SlaveDao;
import io.sample.service.AbstractService;
import io.sample.service.SampleService;

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
public class SampleServiceImpl extends AbstractService implements SampleService {

	final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Autowired
	private SqlSession masterDao;
	@Autowired
	private SqlSession slaveDao;
	@Autowired
    private Configuration configuration;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean insertSample(UserPara userPara) throws Exception {

		int intResult = 0;

		if(this.checkUser(userPara.getUserName())) {
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

	@Override
	public boolean deleteSample(UserDetailPara userDetailPara) throws Exception {
		int intResult = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userDetailPara.getUserName());

		try {
			intResult = masterDao.getMapper(MasterDao.class).deleteUser(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("deleteUser error, userName={}", userDetailPara.getUserName());
			return false;
		}

		return true;
	}

	@Override
	public boolean checkUser(String name) throws Exception {
		UsersModel user = this.selectSample(name);
		if(user == null) {
			return false;
		}
		return true;
	}

	@Override
	public UsersModel selectSample(String name) throws Exception {

		UsersModel sample = new UsersModel();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", name);

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			sample = slaveDao.getMapper(SlaveDao.class).selectUser(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return sample;
	}

	@Override
	public List<UsersModel> selectSampleList() throws Exception {

		List<UsersModel> userList = new ArrayList<UsersModel>();

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			userList = slaveDao.getMapper(SlaveDao.class).selectUsersList();
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return userList;
	}

}