package io.sample.service;

import io.sample.bean.model.UsersModel;
import io.sample.bean.para.user.UserDetailPara;
import io.sample.bean.para.user.UserPara;

import java.util.List;

public interface SampleService {
	public boolean checkUser(String name) throws Exception;
	public boolean insertSample(UserPara userPara) throws Exception;
	public boolean deleteSample(UserDetailPara userDetailPara) throws Exception;
	public List<UsersModel> selectSampleList() throws Exception;
	public UsersModel selectSample(String name) throws Exception;
}