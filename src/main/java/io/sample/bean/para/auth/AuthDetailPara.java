package io.sample.bean.para.auth;

import javax.validation.constraints.NotNull;

public class AuthDetailPara {

	@NotNull(message = "authority must be inputted.")
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}