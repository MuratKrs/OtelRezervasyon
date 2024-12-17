package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = null;
    private Connection conn = null;
    private final String DB_URL = "jdbc:sqlite:C://sqlitedb/Otel.db";

    private Database(){

        try{
            this.conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private Connection getConnection(){
        return conn;
    }

    public static Connection getInstance(){
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Database();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return instance.getConnection();
    }

}
