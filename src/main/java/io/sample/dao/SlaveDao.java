package io.sample.dao;

import io.sample.bean.model.UsersModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface SlaveDao {

	public UsersModel selectUser(Map<String, Object> map) throws SQLException;
	public List<UsersModel> selectUsersList() throws SQLException;

}