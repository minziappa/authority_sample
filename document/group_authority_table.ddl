CREATE DATABASE authority_db DEFAULT CHARACTER SET utf8;

CREATE TABLE groups (
  group_id INT NOT NULL AUTO_INCREMENT,
  group_name VARCHAR(45) NULL,
  insert_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (group_id)
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