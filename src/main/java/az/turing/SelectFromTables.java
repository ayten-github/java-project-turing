package az.turing;

import java.sql.*;

public class SelectFromTables {
    public static void queryUsers() {
        String query = "SELECT * FROM users";

        try (Connection conn = JbdApp.connection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                System.out.printf("ID: %d, Name: %s, Surname: %s, Email: %s, Birthday: %s%n",
                        id, name, surname, email, birthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        queryUsers();
    }
}
