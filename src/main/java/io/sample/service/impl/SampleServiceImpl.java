package io.sample.service.impl;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.SamplePara;
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
	public boolean insertSample(SamplePara samplePara) throws Exception {

		int intResult = 0;

		Map<String, Object> mapSample = new HashMap<String, Object>();
		mapSample.put("userName", samplePara.getUserName());
		mapSample.put("userStatus", samplePara.getUserStatus());

		try {
			intResult = masterDao.getMapper(MasterDao.class).insertSample(mapSample);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
		if(intResult < 1) {
			logger.error("insertSample error, userName={}", samplePara.getUserName());
			return false;
		}

		return true;
	}

	@Override
	public UserModel selectSample(String name) throws Exception {

		UserModel sample = new UserModel();

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
	public List<SampleBean> selectSampleList(SamplePara samplePara) throws Exception {

		List<UserModel> sampleList = new ArrayList<UserModel>();
		List<SampleBean> sampleBeanList = new ArrayList<SampleBean>();

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			sampleList = slaveDao.getMapper(SlaveDao.class).selectUserList();
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		return sampleBeanList;
	}

}