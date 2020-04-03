create database rapid_cart;
USE RAPID_CART;
create user 'rapidcart'@'%' identified by 'rapidcart';
grant all on rapid_cart.* to 'rapidcart'@'%';
FLUSH PRIVILEGES;

CREATE TABLE CUSTOMER (
    ID VARCHAR(100) PRIMARY KEY,
    FIRST_NAME VARCHAR(55),
    LAST_NAME VARCHAR(55),
    AGE INT,
    GENDER VARCHAR(10),
    ADDRESS VARCHAR(255),
    OCCUPATION VARCHAR(255)
);

CREATE TABLE ITEM (
ID VARCHAR(120) PRIMARY KEY,
NAME VARCHAR(100),
QNTY INT,
PRICE INT
);
