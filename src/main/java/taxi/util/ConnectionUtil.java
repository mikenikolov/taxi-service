package taxi.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String JDBC_DRIVER;

    static {
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(ConnectionUtil.class
                    .getClassLoader().getResourceAsStream("database.properties"));
            URL = dbProperties.getProperty("jdbc.url");
            USERNAME = dbProperties.getProperty("jdbc.username");
            PASSWORD = dbProperties.getProperty("jdbc.password");
            JDBC_DRIVER = dbProperties.getProperty("jdbc.driver");
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        } catch (IOException ex) {
            throw new RuntimeException("Can't read a database properties file", ex);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB ", e);
        }
    }
}
