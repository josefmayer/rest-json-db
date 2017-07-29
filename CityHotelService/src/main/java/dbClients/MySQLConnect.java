package dbClients;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class MySQLConnect {

    public MySQLConnect mySQLConnect (){return  new MySQLConnect();}

    //private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/json_example";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
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
                //Class.forName(DATABASE_DRIVER);
                //connection = DriverManager.getConnection(DATABASE_URL, getProperties());
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
