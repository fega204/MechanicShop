package database;
import java.sql.*;

public class DatabaseManager {
    private static DatabaseManager instance = new DatabaseManager();
    private Connection conn;
    private String url = "jdbc:mariadb://localhost:3306/mechanic_shop";
    private String user = "root";
    //private String pass = "Igbunu123";
    private String pass = "root123";

    private DatabaseManager(){ connect(); }
    public static DatabaseManager getInstance(){ return instance; }
    private void connect(){
        try { conn = DriverManager.getConnection(url,user,pass); }
        catch(Exception e){ System.out.println(e.getMessage()); }
    }
    public Connection getConnection(){ return conn; }
    public void closeConnection(){ try{ conn.close(); }catch(Exception e){} }
}