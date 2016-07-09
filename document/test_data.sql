INSERT INTO authority_db.authorities (authority, insert_time, update_time) VALUES ('au01', now(),now());
INSERT INTO authority_db.authorities (authority, insert_time, update_time) VALUES ('au02', now(),now());

INSERT INTO authority_db.user (user_name, user_status, user_pwd, insert_time, update_time) VALUES ('bbb1', '1', 'test', now(), now());
INSERT INTO authority_db.user (user_name, user_status, user_pwd, insert_time, update_time) VALUES ('bbb2', '2', 'test', now(), now());

INSERT INTO authority_db.user_authorities (user_id, authority_id, insert_time, update_time) VALUES ('1', '1', now(),now());
INSERT INTO authority_db.user_authorities (user_id, authority_id, insert_time, update_time) VALUES ('2', '1', now(),now());
INSERT INTO authority_db.user_authorities (user_id, authority_id, insert_time, update_time) VALUES ('3', '2', now(),now());
INSERT INTO authority_db.user_authorities (user_id, authority_id, insert_time, update_time) VALUES ('4', '2', now(),now());