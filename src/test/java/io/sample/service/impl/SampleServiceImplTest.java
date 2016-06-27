package io.sample.service.impl;

import static org.junit.Assert.*;

import io.sample.service.SampleService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class SampleServiceImplTest {

	@Autowired
    SampleService sampleService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void testSelectSample() throws Exception {
//		SelectUserPara selectUser = new SelectUserPara();
//		selectUser.setUserName("admin");
//		selectUser.setUserData("2014-08-10");
//		List<SampleBean> userList = sampleService.selectSampleByName(selectUser);
//		assertNotNull(userList);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}