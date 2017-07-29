use json_example;

IF OBJECT_ID('dbo.cityJson', 'U') IS NOT NULL
  DROP TABLE dbo.cityJson;

CREATE TABLE cityJson (
    jdoc NVARCHAR(250) NOT NULL,
);

IF OBJECT_ID('dbo.hotelJson', 'U') IS NOT NULL
  DROP TABLE dbo.hotelJson;

CREATE TABLE hotelJson (
    jdoc NVARCHAR(250) NOT NULL,
);


IF OBJECT_ID('dbo.hotelCityJson', 'U') IS NOT NULL
  DROP TABLE dbo.hotelCityJson;

CREATE TABLE hotelCityJson (
    jdoc NVARCHAR(250) NOT NULL,
);

IF OBJECT_ID('dbo.json1', 'U') IS NOT NULL
  DROP TABLE dbo.json1;

CREATE TABLE json1 (
    jdoc NVARCHAR(250) NOT NULL,
);



IF OBJECT_ID('dbo.product', 'U') IS NOT NULL
  DROP TABLE dbo.product;

CREATE TABLE product (
    id INT NOT NULL IDENTITY(1,1),
    name NVARCHAR(250) NOT NULL,
    attributes NVARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);
go


