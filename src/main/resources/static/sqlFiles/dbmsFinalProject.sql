-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile
-- source path/dbmsFinalProject.sql

create database bankCardSystem;
use bankCardSystem;

create table BANK ( BANK_ID INT PRIMARY KEY AUTO_INCREMENT, BANK_NAME VARCHAR(45), BANK_POSTER VARCHAR(100) );
INSERT INTO BANK (BANK_NAME, BANK_POSTER) values ('Bank1', 'bank_1.jpeg'), ('Bank2', 'bank_2.jpeg'), ('Bank3', 'bank_3.jpeg'), ('Bank4', 'bank_4.jpeg'), ('Bank5', 'bank_5.jpeg'), ('Bank6', 'bank_6.jpeg');
select * from BANK;

create table USER (
USER_ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(70),
EMAIL VARCHAR(70) UNIQUE,
PASSWORD VARCHAR(200),
TYPE CHAR(1),
PASSWORD_RESET_TOKEN VARCHAR (50));


-- password: sid1234567
INSERT INTO USER (name, email, password, type, password_Reset_Token) values
('Siddhartha Dimania', 'siddimania@gmail.com', 'bJp48xVpIYlJf3oCljwSdvJs5COPphRcR1dfNUYaz+I=$AMiORHZyQGUAvu+xvDNyfx2FleByxy3O9F14mh3i/tk=', 'C', 'not_defined');

