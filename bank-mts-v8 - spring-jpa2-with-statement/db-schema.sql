

create database my_bank;
use my_bank;

create table my_bank.ACCOUNTS(
num varchar(12) primary key,
holderName varchar(200),
balance double,
type varchar(20)
);

insert into my_bank.ACCOUNTS values('1','Nag',1000.00,'SAVING');
insert into my_bank.ACCOUNTS values('2','Ria',1000.00,'SAVING');