package io.sample.service;

import io.sample.bean.model.UsersModel;

public interface LoginService {
	public UsersModel checkLogin(String name) throws Exception;
}