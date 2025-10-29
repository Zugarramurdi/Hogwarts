package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/hp";
    private static final String USER = "root";
    private static final String PASSWORD = "Toor";

    public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅✅✅ Connected to Hogwarts!.");
        } catch (SQLException e) {
            System.err.println("❌❌❌ Connection error: " + e.getMessage());

        }
    return conn;
    }

}
