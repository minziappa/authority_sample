package io.sample.bean.model;

import java.util.Date;

public class UserAuthoritiesModel {

	private int userAuthoritiesId;
	private int userId;
	private int authorityId;
	private Date insertDate;
	private Date updateDate;

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
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
