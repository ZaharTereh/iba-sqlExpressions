CREATE DATABASE iba;

CREATE TABLE user_info(
    id         int          primary key auto_increment ,
    first_name varchar(220) not null ,
    last_name  varchar(220) not null ,
    email      varchar(220) not null
);

CREATE TABLE user(
    id           int          primary key auto_increment ,
    username     varchar(220) not null unique ,
    password     varchar(220) not null ,
    role         varchar(220) not null ,
    state        varchar(220) not null ,
    user_info_id int,

    foreign key (user_info_id) references user_info(id)
);

CREATE TABLE  user_log(
    id        int          primary key auto_increment,
    sql_query varchar(220) not null ,
    message   varchar(220) not null ,
    user_id   int         not null ,

    foreign key (user_id) references user(id)
);


show tables;

SELECT COLUMN_NAME
FROM information_schema.COLUMNS
WHERE TABLE_SCHEMA = DATABASE()
  AND TABLE_NAME = 'user'
ORDER BY ORDINAL_POSITION;

show columns from user;