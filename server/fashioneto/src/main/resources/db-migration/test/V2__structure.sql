/*
 * Foreign keys and any constraints haven't been included yet
 * 
 *	fashionetoer = user (user is a reserved word to be avoided on table names)
 *
 */

create table fashionetoer (
	`id` int(11) unsigned AUTO_INCREMENT not null primary key,
	`username` varchar(100) not null,
	`email` varchar(100) not null,
	`password` varchar(200) not null
);

create table image (
	`id` int(11) unsigned AUTO_INCREMENT not null primary key,
	`filename` varchar(200) not null, 
	`description` varchar(100) not null,
	`type` varchar(50) not null
);

create table item (
	`id` int(11) unsigned AUTO_INCREMENT not null primary key,
	`type` varchar(50) not null
);

create table badge (
	`id` int(11) unsigned AUTO_INCREMENT not null primary key,
	`id_image` int(11) unsigned not null,
	`type` varchar(50) not null
);

create table item_image (
	`id_item` int(11) unsigned not null,
	`id_image` int(11) unsigned not null
);

create table fashionetoer_image (
	`id_fashionetoer` int(11) unsigned not null,
	`id_image` int(11) unsigned not null
);


create table comment (
	`id` int(11) unsigned AUTO_INCREMENT not null primary key,
	`id_user` int(11) unsigned not null,
	`dt_comment` DATETIME not null,
	`content` varchar(200) not null
);

create table comment_parent (
	`id_comment` int(11) unsigned not null primary key,
	`id_parent_comment` int(11) unsigned,
	`id_parent_user` int(11) unsigned,
	`parent_type` varchar(50) not null
);

create table like_item (
	`id_fashionetoer` int(11) unsigned not null,
	`id_item` int(11) unsigned not null
);

create table like_comment (
	`id` int(11) unsigned AUTO_INCREMENT not null primary key,
	`id_user` int(11) unsigned not null,
	`id_comment` int(11) unsigned not null
);

CREATE TABLE user_roles
(
   `id_user` int(11) unsigned not null,
   `roles` varchar(50)
);

/*
 * Dummy data:
 */
insert into fashionetoer (`id`, `username`, `email`, `password`) values (1, 'user', 'john1@doe.com', '949f4ae5896a01d231c6f5af079dff23bab120cec83b787f527bc02b03f8fc91');
insert into fashionetoer (`id`, `username`, `email`, `password`) values (2, 'user2', 'john2@doe.com', 'f82959d41f9330bd853d3e11345e08eda948544666bfc17806493df9d4b305f0');

INSERT INTO user_roles (id_user,roles) VALUES (1,'user');
INSERT INTO user_roles (id_user,roles) VALUES (2,'admin');
INSERT INTO user_roles (id_user,roles) VALUES (2,'user');

-- user 2 leaving a comment for user 1
insert into comment (`id`, `id_user`, `content`, `dt_comment`) values (1, 2, 'I like your pictures and your profile, man!', '2014-03-09 12:30:00');
insert into comment_parent values (1, null, 1, 'USER');	
-- user 1 leaving a reply for comment above
insert into comment (`id`, `id_user`, `content`, `dt_comment`) values (2, 1, 'Thanks!', '2014-03-09 12:30:00');
insert into comment_parent values (2, 1, null, 'COMMENT');

--user 1 liking comment 1
insert into like_comment values (1, 1, 1);