create table student(
id int primary key auto_increment,
name varchar(20),
belong char(3),
tel varchar(13),
p_id int);

create table professor(
id int primary key auto_increment,
name varchar(20) not null,
belong char(3) default 'FOO',
phone varchar(13));`