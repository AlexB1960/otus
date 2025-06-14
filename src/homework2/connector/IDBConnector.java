package homework2.connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBConnector {

    ResultSet executeQuery(String query) throws SQLException;
    void executeUpdate(String query) throws SQLException;
    void execute(String query) throws SQLException;
    void close() throws SQLException;
}
