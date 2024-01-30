drop database twitter;
create database twitter;
use twitter;

create table users (
	user_id int  AUTO_INCREMENT PRIMARY KEY,
	first_name varchar(50),
	email varchar(50),
	password varchar(500),
	picture_path varchar(500)
);

describe users;

create table tweets (
	user_id int,
	tweet_id int AUTO_INCREMENT PRIMARY KEY,
	tweet_text varchar(100),
	tweet_picture varchar(350),
	tweet_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (user_id) REFERENCES users(user_id)
);

describe tweets;


create table followings (
	user_id int,
	following_user_id int,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (following_user_id) REFERENCES users(user_id)
);

describe following;

create view user_tweet_view as
	select  tweets.tweet_id, tweets.tweet_text, tweets.tweet_picture,
	tweets.tweet_date, users.first_name,users.picture_path, tweets.user_id
	from tweets
	inner join users
	on tweets.user_id= users.user_id ;

describe user_tweet_view;