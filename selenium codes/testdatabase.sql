#creating database
create database veeradb;
#point to database 
use veeradb;

#create table
create table EmployeeInfo(name varchar(128),id int,Location varchar(128),age int);

describe EmployeeInfo;
#insert the data
insert into EmployeeInfo values('veera',1,'vijayawada',23);
insert into EmployeeInfo values('sankar',2,'bangalore',25);
insert into EmployeeInfo values('rishi',3,'hydrabad',23);
insert into EmployeeInfo values('raghu',4,'chennai',26);
insert into EmployeeInfo values('veera sankar',5,'tadepalli',26);
select * from EmployeeInfo where name='veera';