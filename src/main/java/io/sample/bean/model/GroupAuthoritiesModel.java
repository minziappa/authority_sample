package io.sample.bean.model;

import java.util.Date;

public class GroupAuthoritiesModel {

	private int groupAuthoritiesId;
	private int groupId;
	private int authorityId;
	private Date insertDate;
	private Date updateDate;
	public int getGroupAuthoritiesId() {
		return groupAuthoritiesId;
	}
	public void setGroupAuthoritiesId(int groupAuthoritiesId) {
		this.groupAuthoritiesId = groupAuthoritiesId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
