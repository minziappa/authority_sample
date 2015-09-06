package io.sample.service.impl;

import io.sample.bean.model.UsersModel;
import io.sample.service.AbstractService;
import io.sample.service.LoginService;
import io.sample.service.SampleService;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends AbstractService implements LoginService {

	final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private SqlSession slaveDao;
	@Autowired
	private SampleService sampleService;

	@Override
	public UsersModel checkLogin(String name) throws Exception {
		return sampleService.selectSample(name);
	}

}