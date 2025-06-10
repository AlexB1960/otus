package homework2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionManager {
    private final Properties prop = new Properties();
    private final InputStream stream = ClassLoader.getSystemResourceAsStream("SQLSettings.properties");

    private Connection connection;
    private Statement statement;
    private static ConnectionManager instance;

    private ConnectionManager() {
        try {
            prop.load(stream);
        } catch (IOException e) {
            System.out.println("Ошибка - " + e.getMessage());
        }

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void execute(String query) throws SQLException {
        statement.execute(query);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

}
