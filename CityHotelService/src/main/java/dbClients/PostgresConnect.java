package dbClients;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class PostgresConnect {

    public PostgresConnect postgresConnect (){return  new PostgresConnect();}

    private static final String DATABASE_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5433/json_example";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    //private static final String MAX_POOL = 250;

    private Connection connection;
    private Properties properties;

    private Properties getProperties(){
        if (properties == null){
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            //properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    public Connection connect() {
        //if (connection == null) {
        //try {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL,getProperties());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //} catch (ClassNotFoundException | SQLException e) {
        //    e.printStackTrace();
        //}
        //}
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
