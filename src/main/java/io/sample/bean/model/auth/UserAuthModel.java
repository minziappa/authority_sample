package io.sample.bean.model.auth;

import java.util.Date;

public class UserAuthModel {
	
	private int userAuthoritiesId;
	private int userId;
	private int authorityId;
	private Date insertTime;
	private Date updateTime;

	public int getUserAuthoritiesId() {
		return userAuthoritiesId;
	}
	public void setUserAuthoritiesId(int userAuthoritiesId) {
		this.userAuthoritiesId = userAuthoritiesId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
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
