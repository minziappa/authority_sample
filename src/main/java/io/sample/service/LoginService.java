package io.sample.service;

import java.util.List;

import io.sample.bean.model.UserModel;
import io.sample.bean.para.login.LoginPara;
import io.sample.bean.para.user.UserPara;

public interface LoginService {
	public UserModel selectUser(String name) throws Exception;
	public List<UserModel> selectUserList(String name) throws Exception;
	public List<UserModel> selectUserList() throws Exception;
	public UserModel checkUserRegistered(LoginPara loginPara) throws Exception;
	public boolean insertUser(UserPara userPara) throws Exception;
	public boolean deleteUser(UserPara userPara) throws Exception;
}