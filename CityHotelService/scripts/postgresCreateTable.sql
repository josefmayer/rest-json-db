\c json_example;

DROP TABLE IF EXISTS cityJson;
CREATE TABLE cityJson (
    jdoc json NOT NULL
);

DROP TABLE IF EXISTS hotelJson;
CREATE TABLE hotelJson (jdoc JSON);

DROP TABLE IF EXISTS hotelCityJson;
CREATE TABLE hotelCityJson (jdoc JSON);

DROP TABLE IF EXISTS json1;
CREATE TABLE json1 (jdoc JSON);


DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id SERIAL,
    name VARCHAR(250) NOT NULL,
    attributes JSON NOT NULL,
    PRIMARY KEY (id)
);