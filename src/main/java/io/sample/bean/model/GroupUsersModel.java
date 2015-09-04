package io.sample.bean.model;

import java.util.Date;

public class GroupUsersModel {

	private int groupUsersId;
	private int groupId;
	private int userId;
	private Date insertDate;
	private Date updateDate;
	public int getGroupUsersId() {
		return groupUsersId;
	}
	public void setGroupUsersId(int groupUsersId) {
		this.groupUsersId = groupUsersId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
