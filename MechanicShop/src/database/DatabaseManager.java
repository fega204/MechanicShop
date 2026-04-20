package database;
import java.sql.*;

public class DatabaseManager {

    private static DatabaseManager instance = new DatabaseManager();
    private Connection conn;

    private String url = "jdbc:mariadb://localhost:3306/mechanic_shop";
    private String user = "root";
    // private String pass = "Igbunu123";
    private String pass = "root123";

    private DatabaseManager() {
        connect();
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    private void connect() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to database!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}