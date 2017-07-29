package dbClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MSSQLClient {

    public MSSQLClient mssqlClient() {return new MSSQLClient();}

    @Autowired
    MSSQLConnect mssqlConnect;

    public void insertCityJson(String indocument) {
        String queryInsert = "INSERT INTO cityJson (jdoc) VALUES (?);";

        try (Connection conn = mssqlConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertHotelJson(String indocument) {
        String queryInsert = "INSERT INTO hotelJson (jdoc) VALUES (?);";

        try (Connection conn = mssqlConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertHotelCityJson(String indocument) {
        String queryInsert = "INSERT INTO hotelCityJson (jdoc) VALUES (?);";

        try (Connection conn = mssqlConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertJson(String indocument) {
        String queryInsert = "INSERT INTO json1 (jdoc) VALUES (?);";

        try (Connection conn = mssqlConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertProduct(String name, String attributes) {
        //String queryInsert = "INSERT INTO product (id, name,attributes) VALUES (NULL, ?, ?);";
        String queryInsert = "INSERT INTO product (name,attributes) VALUES (?, ?);";

        try (Connection conn = mssqlConnect.connect();
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

        try (Connection conn = mssqlConnect.connect();
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

        try (Connection conn = mssqlConnect.connect();
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


}
