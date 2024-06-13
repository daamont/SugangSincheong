package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    Connection connection;
    String url = "jdbc:mysql://localhost/sugangsincheong";
    Statement statement;
    public DatabaseManager() {
        loadDriver();
        if(loadDriver()) {
            this.connection = connectDatabase("root","");
        }
    
    }
    public boolean loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[ system ] load driver --- success");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("[ system ] load driver --- failed");
            e.printStackTrace();
            return false;
        }
    }
    
    public Connection connectDatabase(String id, String pw) {
        try {
            connection = DriverManager.getConnection(url,id,pw);
            System.out.println("[ system ] connect database --- success");
            return connection;
        } catch (SQLException e) {
            System.out.println("[ system ] connect database --- failed");
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getQueryResult(String query) {
        try {
            statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            System.out.println("[ system ] excute query --- success");
            return result;
        } catch (SQLException e) {
            System.out.println("[ system ] excute query --- failed");
            e.printStackTrace();
            return null;
        }
    }
    public int executeUpdate(String query) {
        try {
            statement = this.connection.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println("[ system ] execute update --- success");
            return result;
        } catch (SQLException e) {
            System.out.println("[ system ] execute update --- failed");
            e.printStackTrace();
            return -1;
        }
    }
    public boolean exitDatabase() {
        try {
            connection.close();
            System.out.println("[ system ] exit dateabase --- success");
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("[ system ] exit dateabase --- failed");
            e.printStackTrace();
            return false;
        }
    }
    public Connection getConnection() {
        return this.connection;
    }
}
