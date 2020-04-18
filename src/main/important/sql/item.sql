DROP TABLE ITEM;

CREATE TABLE ITEM (
ID VARCHAR(255) PRIMARY KEY,
NAME VARCHAR(255),
BRAND VARCHAR(255),
QUANTITY INT,
PRICE DECIMAL,
IMAGE_URL VARCHAR(255)
);

INSERT INTO ITEM VALUES('ITEM_PRODUCT_1', 'Knot Front Mini Dress - DB', 'topshop', 100, 80.00, 'resources/img/product-img/product-1.jpg');
INSERT INTO ITEM VALUES('ITEM_PRODUCT_2', 'Poplin Displaced Wrap Dress - DB', 'topshop', 200, 80.00, 'resources/img/product-img/product-2.jpg');
INSERT INTO ITEM VALUES('ITEM_PRODUCT_3', 'PETITE Crepe Wrap Mini Dress - DB', 'mango', 300, 75.00, 'resources/img/product-img/product-3.jpg');
INSERT INTO ITEM VALUES('ITEM_PRODUCT_4', 'PETITE Belted Jumper Dress - DB', 'topshop', 400, 80.00, 'resources/img/product-img/product-4.jpg');