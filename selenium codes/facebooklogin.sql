#creating database
create database facebookdb;
#point to database 
use facebookdb;

#create table
create table facebook(id int,username varchar(128),password varchar(128));

describe facebook;
#insert the data
insert into facebook values(1,'9177157021','veera(ru)');


select * from facebook where id=1;