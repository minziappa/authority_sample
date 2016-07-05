package io.sample.bean.model.auth;

import java.io.Serializable;
import java.util.Date;

public class AuthModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int authorityId;
	private String authority;
	private Date insertTime;
	private Date updateTime;

	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
