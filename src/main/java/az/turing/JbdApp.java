package az.turing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JbdApp {
    public static Connection connection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5434/postgres",
                    "postgres",
                    "12345"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        connection();
    }
}
