package io.sample.bean.para;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class SamplePara {

    @NotNull(message = "userId")
    @Size(min = 1, max = 45 ,message = "userId")
	private String userId;
    @NotNull(message = "userName")
    @Size(min = 1, max = 45 ,message = "userName")
	private String userName;
    @NotNull(message = "userAge")
    @Size(min = 1, max = 3 ,message = "userAge")
	private String userStatus;

	private MultipartFile userImg;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public MultipartFile getUserImg() {
		return userImg;
	}

	public void setUserImg(MultipartFile userImg) {
		this.userImg = userImg;
	}

}