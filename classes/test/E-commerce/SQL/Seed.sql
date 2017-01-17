use eCommerceTest;

TRUNCATE TABLE products;

INSERT INTO products (name, stocknumber, listprice, actualprice, restricted, description)
VALUES ('Ring', 'APB100', 2000, 2000, 1, 'test' );