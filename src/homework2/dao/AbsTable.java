package homework2.dao;

import homework2.connector.MySqlConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsTable {
    protected String tableName;
    protected Map<String, String> columns = new HashMap<>();

    public AbsTable(String tableName) {
        this.tableName = tableName;
    }

    public void create() {
        String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %s (%s)", this.tableName, convertMapColumnsToString());
        try {
            MySqlConnector.getInstance().execute(sqlRequest);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertMapColumnsToString() {
        /*String result = "";
        for(Map.Entry<String, String> el : columns.entrySet()){
            result += el.getKey() + " " + el.getValue() + ",";
        }
        result = result.substring(0, result.length()-1);
        return result;*/
        return "id bigint PRIMARY KEY AUTO_INCREMENT, name varchar(15), type varchar(15), " +
                "age int, weight int, color varchar(15)";
    }

}
