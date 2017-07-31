package dbClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PostgresClient {

    public PostgresClient postgresClient() {return new PostgresClient();}

    @Autowired
    PostgresConnect postgresConnect;

    public void insertCityJson(String indocument) {
        String queryInsert = "INSERT INTO cityJson (jdoc) VALUES (to_json(?::json))";

        try (Connection conn = postgresConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
           psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertHotelJson(String indocument) {
        String queryInsert = "INSERT INTO hotelJson (jdoc) VALUES (to_json(?::json))";

        try (Connection conn = postgresConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertHotelCityJson(String indocument) {
        String queryInsert = "INSERT INTO hotelCityJson (jdoc) VALUES (to_json(?::json))";

        try (Connection conn = postgresConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertJson(String indocument) {
        String queryInsert = "INSERT INTO json1 (jdoc) VALUES (to_json(?::json))";

        try (Connection conn = postgresConnect.connect();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)){

            psInsert.setString(1, indocument);
            psInsert.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertProduct(String name, String attributes) {
        //String queryInsert = "INSERT INTO product (id, name,attributes) VALUES (NULL, ?, ?);";
        String queryInsert = "INSERT INTO product (name,attributes) VALUES (?, to_json(?::json));";

        try (Connection conn = postgresConnect.connect();
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

        try (Connection conn = postgresConnect.connect();
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

        try (Connection conn = postgresConnect.connect();
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
