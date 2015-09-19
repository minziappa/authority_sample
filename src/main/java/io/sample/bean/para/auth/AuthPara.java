package io.sample.bean.para.auth;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthPara {

    @NotNull(message = "authority")
    @Size(min = 1, max = 45 ,message = "authority")
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}