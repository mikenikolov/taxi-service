package taxi.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String JDBC_DRIVER;
    private static final String DATABASE_PROPERTIES_FILE = "database.properties";

    static {
        try (InputStream resourceAsStream = ConnectionUtil.class.getClassLoader()
                .getResourceAsStream(DATABASE_PROPERTIES_FILE)) {
            Properties dbProperties = new Properties();
            dbProperties.load(resourceAsStream);
            URL = dbProperties.getProperty("jdbc.url");
            USERNAME = dbProperties.getProperty("jdbc.username");
            PASSWORD = dbProperties.getProperty("jdbc.password");
            JDBC_DRIVER = dbProperties.getProperty("jdbc.driver");
        } catch (IOException e) {
            throw new RuntimeException("Can't read a database properties file", e);
        }
    }

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
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
