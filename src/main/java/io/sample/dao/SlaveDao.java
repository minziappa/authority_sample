package io.sample.dao;

import io.sample.bean.model.UserModel;
import io.sample.bean.model.auth.AuthJoinUsersModel;
import io.sample.bean.model.auth.AuthModel;
import io.sample.bean.model.auth.UserAuthModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface SlaveDao {

	public UserModel selectUser(Map<String, Object> map) throws SQLException;
	public AuthModel selectAuth(Map<String, Object> map) throws SQLException;
	public UserAuthModel selectUserAuth(Map<String, Object> map) throws SQLException;
	public List<UserModel> selectUsersList(Map<String, Object> map) throws SQLException;
	public List<UserModel> selectUsersList() throws SQLException;
	public List<AuthModel> selectAuthList() throws SQLException;

	public List<AuthJoinUsersModel> selectAuthJoinUserMapList() throws SQLException;
}