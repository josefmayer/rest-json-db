package dbClients;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Josef Mayer on 23.06.2017.
 */

@Configuration
public class MySQLClient {

    public MySQLClient mySQLclient(){
        return new MySQLClient();
    }

    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/json_example";
    private final String user = "root";
    private final String password = "root";

    public void createTable() {
        String query = "CREATE TABLE json1 (id int not null primary key auto_increment, jdoc JSON);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query)){
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertCityJson(String indocument) {
        String queryInsert = "INSERT INTO `cityJson` (`jdoc`) VALUES (?);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertHotelJson(String indocument) {
        String queryInsert = "INSERT INTO `hotelJson` (`jdoc`) VALUES (?);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertHotelCityJson(String indocument) {
        String queryInsert = "INSERT INTO `hotelCityJson` (`jdoc`) VALUES (?);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertJson(String indocument) {
        String queryInsert = "INSERT INTO `json1` (`jdoc`) VALUES (?);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertProduct(String name, String attributes) {
        String queryInsert = "INSERT INTO `product` (`id`, `name`,`attributes`) VALUES (NULL, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, name);
            psInsert.setString(2, attributes);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<String> findAllCities() {
        String query = "SELECT jdoc FROM cityJson";
        List<String> resultList = new ArrayList<String>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)){

            while (rs.next()){
                resultList.add(rs.getString("jdoc"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultList;
    }

    public List<String> findAllHotels() {
        String query = "SELECT jdoc FROM hotelJson";
        List<String> resultList = new ArrayList<String>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)){

            while (rs.next()){
                resultList.add(rs.getString("jdoc"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultList;
    }



    public List<Object> getAll() {
        String queryString = "SELECT jdoc FROM cityJson";
        List<Object> resultList = new ArrayList<Object>();

        ResultSetHandler<List<Object>> h = new ResultSetHandler<List<Object>>() {
            public List<Object> handle(ResultSet rs) throws SQLException {
                List<Object> resultList = new ArrayList<Object>();
                while (rs.next()){
                    resultList.add(rs.getString("jdoc"));
                }
                return resultList;
            }
        };

        QueryRunner run = new QueryRunner(getDataSource());
        try {
            resultList = run.query(queryString, h);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }


//    public List<Object> getAll() {
//        String queryString = "SELECT jdoc FROM gaussian2";
//        List<Object> resultList = new ArrayList<Object>();
//
//        try (Connection conn = DriverManager.getConnection(url, user, password);){
//
//        new QueryRunner()
//                .query(conn, queryString, new ArrayListHandler())
//                .stream()
//                //.map(array -> new Schema(
//                //    (String) array[0],
//                //))
//                .forEach(System.out::println);
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return resultList;
//    }

    private DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

}


