package io.sample.bean.para.auth;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUsersPara {

    @NotNull(message = "authority")
    @Size(min = 1, max = 45 ,message = "authority")
	private String authorityId;

    @NotNull(message = "usersAuth")
    @Size(min = 1, max = 45 ,message = "usersAuth")
    private String [] userIdAuth;

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String[] getUserIdAuth() {
		return userIdAuth;
	}

	public void setUserIdAuth(String[] userIdAuth) {
		this.userIdAuth = userIdAuth;
	}

}