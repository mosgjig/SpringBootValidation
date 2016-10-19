create table users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

INSERT INTO users(username,password,enabled) VALUES ('user','password', true);