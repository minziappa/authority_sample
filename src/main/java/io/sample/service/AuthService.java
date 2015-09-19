package io.sample.service;

import io.sample.bean.model.auth.AuthModel;
import io.sample.bean.para.auth.AuthPara;

import java.util.List;

public interface AuthService {
	public boolean checkAuth(String authority) throws Exception;
	public AuthModel selectAuth(String name) throws Exception;
	public boolean insertAuth(AuthPara authPara) throws Exception;
	public List<AuthModel> selectAuthList() throws Exception;
}