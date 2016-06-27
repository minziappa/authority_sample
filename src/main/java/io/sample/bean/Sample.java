package io.sample.bean;

import io.sample.bean.model.UserModel;
import io.sample.bean.model.auth.AuthModel;

import java.util.List;

public class Sample {

	private UserModel users;
	private List<UserModel> usersList;
	private AuthModel auth;
	private List<AuthModel> authList;
	private String navi;
	private String menu;
    private String errorMessage;

	public UserModel getUsers() {
		return users;
	}
	public void setUsers(UserModel users) {
		this.users = users;
	}
	public List<UserModel> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<UserModel> usersList) {
		this.usersList = usersList;
	}
	public AuthModel getAuth() {
		return auth;
	}
	public void setAuth(AuthModel auth) {
		this.auth = auth;
	}
	public List<AuthModel> getAuthList() {
		return authList;
	}
	public void setAuthList(List<AuthModel> authList) {
		this.authList = authList;
	}
	public String getNavi() {
		return navi;
	}
	public void setNavi(String navi) {
		this.navi = navi;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
