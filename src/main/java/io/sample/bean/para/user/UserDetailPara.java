package io.sample.bean.para.user;

import javax.validation.constraints.NotNull;

public class UserDetailPara {

	@NotNull(message = "userName must be inputted.")
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}