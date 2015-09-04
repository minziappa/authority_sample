package io.sample.bean.para;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserPara {

    @NotNull(message = "userName")
    @Size(min = 1, max = 45 ,message = "userName")
	private String userName;
    @NotNull(message = "userPwd")
    @Size(min = 1, max = 45 ,message = "userPwd")
	private String userPwd;
    @NotNull(message = "userStatus")
    @Size(min = 1, max = 3 ,message = "userStatus")
	private String userStatus;

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}