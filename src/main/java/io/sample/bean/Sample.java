package io.sample.bean;

import io.sample.bean.model.UsersModel;

import java.util.List;

public class Sample {

	private UsersModel users;
	private List<UsersModel> usersList;
	private String navi;
    private String errorMessage;


	public UsersModel getUsers() {
		return users;
	}
	public void setUsers(UsersModel users) {
		this.users = users;
	}
	public List<UsersModel> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<UsersModel> usersList) {
		this.usersList = usersList;
	}
	public String getNavi() {
		return navi;
	}
	public void setNavi(String navi) {
		this.navi = navi;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
