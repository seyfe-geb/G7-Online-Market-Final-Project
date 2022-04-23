
--Roles

INSERT INTO roles (id, authority) VALUES (1, 'ADMIN');
INSERT INTO roles (id, authority) VALUES (2, 'SELLER');
INSERT INTO roles (id, authority) VALUES (3, 'BUYER');


--Users and Roles

--User 1
INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
VALUES (1, '2022-04-04', 'fri@miu.com', 1, 'Fridom', 1, 'Araya', '2022-04-04', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'free');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);


--User 2
INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
VALUES (2, '2022-04-13', 'erm@miu.com', 1, 'Ermias', 1, 'Ghebrez', '2022-04-13', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'ermiji');

INSERT INTO USER_ROLES(user_id, role_id) VALUES (2, 2);


--User 3
INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
VALUES (3, '2022-04-14', 'star@miu.com', 1, 'Star', 0, 'Tsegay', '2022-04-14', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'star');

INSERT INTO USER_ROLES(user_id, role_id) VALUES (3, 3);


--User 4

INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
VALUES (4, '2022-04-15', 'essei@miu.com', 1, 'Esei', 0, 'Kahsay', '2022-04-15', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'essei');

INSERT INTO USER_ROLES(user_id, role_id) VALUES (4, 3);


--User 5
INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
VALUES (5, '2022-04-16', 'seyfe@miu.com', 1, 'Seyfe', 0, 'Gebriel', '2022-04-16', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'seyfe');

INSERT INTO USER_ROLES(user_id, role_id) VALUES (5, 3);

--User 6
INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
VALUES (6, '2022-04-17', 'admin@miu.com', 1, 'Admin', 0, 'Administrator', '2022-04-17', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'admin');

INSERT INTO USER_ROLES(user_id, role_id) VALUES (6, 1);


--FOLLOWS
INSERT INTO follows (id, followee_id, follower_id) VALUES (1, 1, 3);

INSERT INTO follows (id, followee_id, follower_id) VALUES (2, 2, 3);

INSERT INTO follows (id, followee_id, follower_id) VALUES (3, 1, 4);

INSERT INTO follows (id, followee_id, follower_id) VALUES (4, 2, 4);

INSERT INTO follows (id, followee_id, follower_id) VALUES (5, 1, 5);

INSERT INTO follows (id, followee_id, follower_id) VALUES (6, 2, 5);
--
-- --ADDRESSES
INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (1, 'FairField', 'IA', '123ST',   1, '123456', 1);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (2, 'FairField', 'IA', '123ST',   2, '123456', 1);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (3, 'Uttamwa', 'IA', '234ST',   1, '234567', 2);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (4, 'Uttamwa', 'IA', '234ST',   2, '234567', 2);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (5, 'MountPleasant', 'IA', '345ST',   1, '345678', 3);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (6, 'MountPleasant', 'IA', '345ST',   2, '345678', 3);


INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (7, 'Iowa City', 'IA', '456ST',   1, '456789', 4);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (8, 'Iowa City', 'IA', '456ST',   2, '456789', 4);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (9, 'Des Moins', 'IA', '567ST',   1, '567891', 5);

INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
values (10, 'Des Moins', 'IA', '567ST',   2, '567891', 5);
--
--PAYMENT_METHOD
INSERT INTO payment_methods (id, csv, is_default, name, number, type, billing_address_id, user_id)
values (1, 142, 1, 'seyfe', '1234567891234567', 1, 9, 5);

-- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- values (2, 3, '234567', '2022-04-12', 'DEBIT', 2);
--
-- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- values (3, 5, '345678', '2022-04-13', 'CREDIT', 3);
--
-- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- values (4, 7, '456789', '2022-04-14', 'DEBIT', 4);
--
-- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- values (5, 9, '567891', '2022-04-15', 'CREDIT', 5);
--
--
-- --PRODUCTS
INSERT INTO products (id, description, name, price, quantity, user_id )
VALUES (1, 'It is a transport mechanism', 'Bicycle', 100.00, 14, 1);

INSERT INTO products (id, description, name, price, quantity, user_id  )
VALUES (2, 'Stationery writing object', 'Pen', 0.50, 5, 2);

INSERT INTO products (id, description, name, price, quantity, user_id  )
VALUES (3, 'Maximize your carry', 'Bag',60, 5, 1);

INSERT INTO products (id, description, name, price, quantity, user_id  )
VALUES (4, ' cellular phone', 'iPhone', 10, 5, 2);


--PRODUCT IMAGES

INSERT INTO product_images (id, image_uri, name, product_id)
VALUES (1, 'https://www.financialexpress.com/wp-content/uploads/2021/06/world-bicycle-day-2021-hero-lectro-c5.jpg', 'bicycle', 1);

INSERT INTO product_images (id, image_uri, name, product_id)
VALUES (2, 'https://m.media-amazon.com/images/I/71LbzzDezeL._AC_SY355_.jpg', 'pen', 2);

INSERT INTO product_images (id, image_uri, name, product_id)
VALUES (3, 'https://m.media-amazon.com/images/I/81idlqFqcUL._AC_SL1500_.jpg', 'bag', 3);

INSERT INTO product_images (id, image_uri, name, product_id)
VALUES (4, 'https://media.wired.com/photos/5d803f5dc891950008ce3447/master/pass/iphone-11_6175-Edit.jpg', 'iphone', 4)





-- -- --ShoppingCart
-- INSERT INTO shopping_cart (id,user_id)
-- values (10,3);
--
-- INSERT INTO shopping_cart (id,user_id)
-- values (21,4);
--
-- INSERT INTO shopping_cart (id,user_id)
-- values (33,5);
--
-- -- --ShoppingCart Item
-- INSERT INTO shopping_cart_items (id, quantity, shopping_cart_id, product_id)
-- values (1, 10, 1,1);
-- --
-- INSERT INTO shopping_cart_items (id, quantity, shopping_cart_id, product_id)
-- values (2, 5, 2,2);
--
-- INSERT INTO shopping_cart_items (id, quantity, shopping_cart_id, product_id)
-- values (3, 2, 3,3);