//package io.sample.service.impl;
//
//import io.sample.bean.model.UserModel;
//import io.sample.bean.para.user.UserDetailPara;
//import io.sample.bean.para.user.UserPara;
//import io.sample.dao.MasterDao;
//import io.sample.dao.SlaveDao;
//import io.sample.service.AbstractService;
//import io.sample.service.SampleService;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.configuration.Configuration;
//import org.apache.ibatis.session.SqlSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class SampleServiceImpl extends AbstractService implements SampleService {
//
//	final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
//
//	@Autowired
//	private SqlSession masterDao;
//	@Autowired
//	private SqlSession slaveDao;
//	@Autowired
//    private Configuration configuration;
//	@Override
//	public List<UserModel> selectSampleList() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}