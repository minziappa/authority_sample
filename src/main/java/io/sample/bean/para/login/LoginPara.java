package io.sample.bean.para.login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginPara {

    @NotNull(message = "user name")
    @Size(min = 1, max = 45 ,message = "user name")
	private String userName;

    @NotNull(message = "user password")
    @Size(min = 1, max = 45 ,message = "user password")
	private String userPwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


}
