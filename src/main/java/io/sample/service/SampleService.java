package io.sample.service;

import io.sample.bean.model.UserModel;
import io.sample.bean.para.user.UserDetailPara;
import io.sample.bean.para.user.UserPara;

import java.util.List;

public interface SampleService {
	public List<UserModel> selectSampleList() throws Exception;
}