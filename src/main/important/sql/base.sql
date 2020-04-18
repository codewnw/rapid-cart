create database rapid_cart;

USE RAPID_CART;

create user 'rapidcart'@'%' identified by 'rapidcart';
grant all on rapid_cart.* to 'rapidcart'@'%';

FLUSH PRIVILEGES;