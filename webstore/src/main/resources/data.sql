INSERT INTO ADDRESS (ID, CITY, STATE, COUNTRY, ZIP_CODE)
    VALUES (-1, 'Fairfield', 'Iowa', 'US', '52556');
INSERT INTO ADDRESS (ID, CITY, STATE, COUNTRY, ZIP_CODE)
    VALUES (-2, 'Fairfield', 'Iowa', 'US', '52556');
INSERT INTO PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, PHONE, ENABLED)
    VALUES (-1, 'Admin', 'Admin', 'admin@mum.edu', -1, '+15179189395', 1);

INSERT INTO PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, PHONE, ENABLED)
    VALUES (-2, 'Customer', 'Customer', 'customer@mum.edu', -2, '+15179189395', 1);

INSERT INTO PAYMENT (ID, FIRST_NAME ,LAST_NAME,BILL_ADDRESS_ID, SHIP_ADDRESS_ID, CARD_TYPE, CARD_NO, EXP_MONTH_YEAR, CVC, AVAILABLE_BALANCE, LIMIT, ENABLED)
    VALUES (-1, 'FIRST_NAME' ,'LAST_NAME',-1, -1, 'MasterCard', '123456791234', '08/21', '123', 500, 1000, 1);

INSERT INTO ROLE(ID, ROLE) VALUES(-1, 'ROLE_ADMIN');
INSERT INTO ROLE(ID, ROLE) VALUES(-2, 'ROLE_CUSTOMER');
-- pass = 123456
INSERT INTO USER(ID, EMAIL, PASSWORD, ENABLED) VALUES(-1, 'admin@mum.edu', '$2a$04$pQeYdWnoGFRuxc2GZWMiVuA.lQ345CrC8FDc2cTY4FuRnI4C8rGf.', 1);
INSERT INTO USER_ROLE(ID, USER_ID, ROLE_ID) VALUES(-1, -1, -1);

INSERT INTO USER(ID, EMAIL, PASSWORD, ENABLED) VALUES(-2, 'customer@mum.edu', '$2a$04$pQeYdWnoGFRuxc2GZWMiVuA.lQ345CrC8FDc2cTY4FuRnI4C8rGf.', 1);
INSERT INTO USER_ROLE(ID, USER_ID, ROLE_ID) VALUES(-2, -2, -2);


INSERT INTO PRODUCT (ID, CATEGORY, CREATED_AT, DESCRIPTION, IMAGEURL, IS_AVAILABLE, MANUFACTURER, NAME, PRICE, UPDATED_AT) VALUES
    (-1, 'SHIRT', '2018-04-21', 'Cozy up with this full-zip hoodie.', 'http://localhost:8080/image/10-14153B.jpg', TRUE, 'Nike', 'Grey Heather Fleece Zip Hoodie', 38.85, '2018-04-21');

INSERT INTO PRODUCT (ID, CATEGORY, CREATED_AT, DESCRIPTION, IMAGEURL, IS_AVAILABLE, MANUFACTURER, NAME, PRICE, UPDATED_AT) VALUES
    (-2, 'SHIRT', '2018-04-21', 'The ultimate in fit and fabric, this Vastrm hoodie doesn''t disappoint.', 'http://localhost:8080/image/10-14154B.jpg', TRUE, 'Google', 'Vastrm Hoodie', 200.00, '2018-04-21');

INSERT INTO PRODUCT (ID, CATEGORY, CREATED_AT, DESCRIPTION, IMAGEURL, IS_AVAILABLE, MANUFACTURER, NAME, PRICE, UPDATED_AT) VALUES
    (-3, 'SHIRT', '2018-04-21', 'Perhaps the equivalent to that comfort blanket you had years ago is a cozy fleece.', 'http://localhost:8080/image/10-14159B.jpg', TRUE, 'Apple', 'Men''s Voyage Fleece Jacket', 48.00, '2018-04-21');

INSERT INTO PRODUCT (ID, CATEGORY, CREATED_AT, DESCRIPTION, IMAGEURL, IS_AVAILABLE, MANUFACTURER, NAME, PRICE, UPDATED_AT) VALUES
    (-4, 'SHIRT', '2018-04-21', 'This cozy Android hoodie features a sublimated camo design printed inside hood and along inner sleeves and side panels.', 'http://localhost:8080/image/10-14160B.jpg', TRUE, 'Jack&Jones', 'Android Colorblock Hooded Pullover', 50.20, '2018-04-21');

INSERT INTO PRODUCT (ID, CATEGORY, CREATED_AT, DESCRIPTION, IMAGEURL, IS_AVAILABLE, MANUFACTURER, NAME, PRICE, UPDATED_AT) VALUES
    (-5, 'SHIRT', '2018-04-21', 'Our popular flex fleece hoodie, now for YouTube fans everywhere.', 'http://localhost:8080/image/10-15103B.jpg', TRUE, 'Adidas', 'YouTube Unisex Flex Fleece Zip Hoodie', 45.25, '2018-04-21');

INSERT INTO PRODUCT (ID, CATEGORY, CREATED_AT, DESCRIPTION, IMAGEURL, IS_AVAILABLE, MANUFACTURER, NAME, PRICE, UPDATED_AT) VALUES
    (-6, 'SHIRT', '2018-04-21', 'If you find that the ''spark'' is missing from your outfit, you may need to add one of these full-zip hoodies to the mix.', 'http://localhost:8080/image/10-24099B.jpg', TRUE, 'Polo', 'Fleece Full-Zip Hoodie', 56.65, '2018-04-21');