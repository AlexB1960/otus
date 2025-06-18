package homework2.connector;

import homework2.settings.PropertiesSettings;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class MySqlConnector implements IDBConnector {

    private Map<String, String> dbSettings = null;
    private static Connection connection = null;
    private static Statement statement = null;

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

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void execute(String query) throws SQLException {
        statement.execute(query);
    }

}
