package io.sample.dao;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MasterDao {

	public int insertUser(Map<String, Object> map) throws SQLException;

}