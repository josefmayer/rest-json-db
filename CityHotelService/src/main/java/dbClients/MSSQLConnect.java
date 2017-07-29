package dbClients;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class MSSQLConnect {

    public MSSQLConnect mssqlConnect (){return  new MSSQLConnect();}

    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/json_example";
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=json_example;integratedSecurity=true;";
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
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //connection = DriverManager.getConnection(DATABASE_URL, getProperties());
        try {
            //connection = DriverManager.getConnection(DATABASE_URL,getProperties());
            connection = DriverManager.getConnection(DATABASE_URL);
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
