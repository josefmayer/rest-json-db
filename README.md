## Rest, JSON, Database 
Rest-Service <br />
Storing data as Json string in database<br />



### Technologies
Application: SpringBoot <br />
Rest: SpringRest, JSON <br />
Database: MySQL, MSSQL <br />
Testing: Rest-assured  <br />


### Data Model Rest
Data types for JSON-serialization: <br />
CityJson, HotelJson, CityHotelJson <br />
JSon1, Product  <br />



### Steps
##### MySQL
Start MySQL <br />
Create database 'json_example' <br />
Create tables:  <br />
script databaseCreateTable.sh <br />
*gradle createTablesMySQL* <br />

##### MSSQL
Start MSSQL <br />
Create database 'json_example' <br />
Create tables:  <br />
script mssqlDBcreateTable.bat <br />
*gradle createTablesMSSQL* <br />


##### Run Rest Service
cd CityHotelService  <br />
*gradle clean assemble* <br />
*java -jar build/libs/jar-name.jar*  <br />


##### Run Test Rest-assured
cd ClientRestAssured  <br />
*gradle bootRun*  <br />






