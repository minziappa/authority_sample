package io.sample.service;

import io.sample.bean.model.UsersModel;
import io.sample.bean.para.UserPara;

import java.util.List;

public interface SampleService {
	public boolean insertSample(UserPara userPara) throws Exception;
	public List<UsersModel> selectSampleList() throws Exception;
	public UsersModel selectSample(String name) throws Exception;
}