package io.sample.dao;

import io.sample.bean.model.UserModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SlaveDao {

	public UserModel selectUser(Map<String, Object> map) throws SQLException;
	public List<UserModel> selectUserList() throws SQLException;

}