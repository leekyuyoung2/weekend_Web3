
CREATE DATABASE IF NOT EXISTS mysns
DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE mysns;
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user(
    id VARCHAR(128) PRIMARY KEY, -- "email"
    password VARCHAR(32),
    name VARCHAR(32),
    ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS feed;
CREATE TABLE IF NOT EXISTS feed (
    no INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(128),    
    content VARCHAR(4096),
    ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

alter table feed add column images varchar(1024);

------------------------------------------------------------------------------

USE mysns;

INSERT INTO user VALUES("kim@abc.com", "111", "김시민", now());
INSERT INTO user VALUES("lee@abc.com", "111", "이순신", now());
INSERT INTO user VALUES("kwon@abc.com", "111", "권율", now());

INSERT INTO feed(id, content) VALUES("kim@abc.com", "Hello");
INSERT INTO feed(id, content) VALUES("kwon@abc.com", "Aloha");


-------------------------------------------------------------------------------
select * from user;

select * from user where id ='abc@abc.com';

select * from feed;
