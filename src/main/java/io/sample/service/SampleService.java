package io.sample.service;

import io.sample.bean.SampleBean;
import io.sample.bean.model.UserModel;
import io.sample.bean.para.SamplePara;

import java.util.List;

public interface SampleService {
	public boolean insertSample(SamplePara samplePara) throws Exception;
	public List<SampleBean> selectSampleList(SamplePara samplePara) throws Exception;
	public UserModel selectSample(String name) throws Exception;
}