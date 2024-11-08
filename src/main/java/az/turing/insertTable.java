package az.turing;

import java.sql.*;

public class insertTable {
    public static void insertUsers(){
        String insertUserSQL = "INSERT INTO users (id, name, surname, email, birthday, created_by, created_at, last_login, password, updated_by, bio) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = JbdApp.connection();
             PreparedStatement p = conn.prepareStatement(insertUserSQL)) {

            p.setInt(1, 1);
            p.setString(2, "Anna");
            p.setString(3, "Illisoy");
            p.setString(4, "anli@example.com");
            p.setDate(5, Date.valueOf("1999-11-12"));
            p.setInt(6, 1);
            p.setTimestamp(7, Timestamp.valueOf("2020-11-01 18:11:10"));
            p.setTimestamp(8, Timestamp.valueOf("2021-11-01 12:59:59"));
            p.setString(9, "password12345");
            p.setInt(10, 1);
            p.setString(11, "Developer");
            p.executeUpdate();
            p.setInt(1, 2);
            p.setString(2, "Emil");
            p.setString(3, "Aliyev");
            p.setString(4, "aaliyev.@example.com");
            p.setDate(5, Date.valueOf("1995-07-22"));
            p.setInt(6, 2);
            p.setTimestamp(7, Timestamp.valueOf("2023-11-11 03:24:26"));
            p.setTimestamp(8, Timestamp.valueOf("2023-11-01 09:22:09"));
            p.setString(9, "password121212");
            p.setInt(10, 2);
            p.setString(11, "Senior");
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPosts() {
        String insertPostSQL = "INSERT INTO posts (id, user_id, title, view, created_at, created_by, updated_at, updated_by, post_like) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = JbdApp.connection();
             PreparedStatement p = con.prepareStatement(insertPostSQL)) {

            p.setInt(1, 1);
            p.setInt(2, 1);
            p.setString(3, "Java");
            p.setInt(4, 100);
            p.setTimestamp(5, Timestamp.valueOf("2024-11-11 12:32:29"));
            p.setInt(6, 1);
            p.setTimestamp(7, Timestamp.valueOf("2024-11-12 01:02:03"));
            p.setInt(8, 1);
            p.setInt(9, 10);
            p.executeUpdate();

            p.setInt(1, 2);
            p.setInt(2, 2);
            p.setString(3, "Traveling");
            p.setInt(4, 250);
            p.setTimestamp(5, Timestamp.valueOf("2024-11-11 12:33:40"));
            p.setInt(6, 1);
            p.setTimestamp(7, Timestamp.valueOf("2023-12-13 15:00:00"));
            p.setInt(8, 1);
            p.setInt(9, 5);
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertComments() {
        String insertCommentSQL = "INSERT INTO comments (id, post_id, user_id, content, created_at, created_by, comment_like) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = JbdApp.connection();
             PreparedStatement p = conn.prepareStatement(insertCommentSQL)) {
            p.setInt(1, 1);
            p.setInt(2, 1);
            p.setInt(3, 1);
            p.setString(4, "Great post on Java!");
            p.setTimestamp(5, Timestamp.valueOf("2024-11-11 12:45:00"));
            p.setInt(6, 1);
            p.setInt(7, 3);
            p.executeUpdate();
            p.setInt(1, 2);
            p.setInt(2, 2);
            p.setInt(3, 2);
            p.setString(4, "I love traveling too!");
            p.setTimestamp(5, Timestamp.valueOf("2024-11-11 12:50:00"));
            p.setInt(6, 2);
            p.setInt(7, 5);
            p.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertUsers();
        insertPosts();
        insertComments();
    }
}

