CREATE DATABASE authority_db DEFAULT CHARACTER SET utf8;

CREATE TABLE user (
  user_id INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(100) NULL,
  user_status CHAR(1) NULL,
  user_pwd VARCHAR(100) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (user_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX user_name_idx1 ON user (user_name);

CREATE TABLE groups (
  group_id INT NOT NULL AUTO_INCREMENT,
  group_name VARCHAR(45) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (group_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE TABLE authorities (
  authority_id INT NOT NULL AUTO_INCREMENT,
  authority VARCHAR(45) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (authority_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_authorities (
	user_authorities_id INT NOT NULL AUTO_INCREMENT,
	user_id INT NOT NULL,
	authority_id INT NULL,
	insert_time TIMESTAMP NULL,
	update_time TIMESTAMP NULL,
	PRIMARY KEY (user_authorities_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE TABLE group_users (
	group_users_id INT NOT NULL AUTO_INCREMENT,
	group_id INT NULL,
	user_id INT NULL,
	insert_time TIMESTAMP NULL,
	update_time TIMESTAMP NULL,
	PRIMARY KEY (group_users_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

CREATE TABLE group_authorities (
	group_authorities_id INT NOT NULL AUTO_INCREMENT,
	group_id INT NULL,
	authority_id INT NULL,
	insert_time TIMESTAMP NULL,
	update_time TIMESTAMP NULL,
	PRIMARY KEY (group_authorities_id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;