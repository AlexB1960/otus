package homework2.connector;

import homework2.settings.ISettings;
import homework2.settings.PropertiesSettings;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class MySqlConnector implements IDBConnector {

    private Map<String, String> dbSettings = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static MySqlConnector instance;

    public MySqlConnector() throws SQLException, IOException {
        dbSettings = new PropertiesSettings().getSettings("DBSettings.properties");
        connect();
    }

    private void connect() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    this.dbSettings.get("url"),
                    this.dbSettings.get("username"),
                    this.dbSettings.get("password")
            );
        }
        if (statement == null) {
            statement = connection.createStatement();
        }
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }



    /*private final Properties prop = new Properties();
    private final InputStream stream = ClassLoader.getSystemResourceAsStream("homework2/resources/DBSettings.properties");

    private Connection connection;
    private Statement statement;
    private static MySqlConnector instance;

    private MySqlConnector() {
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
    }*/

    public static MySqlConnector getInstance() throws SQLException, IOException {
        if (instance == null) {
            instance = new MySqlConnector();
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

   /* public void close() throws SQLException {
        statement.close();
        connection.close();
    }*/

}
