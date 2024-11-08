package az.turing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingTables {
    public static void createTable(){
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users " +
                "(id SERIAL PRIMARY KEY, " +
                "name varchar(35) NOT NULL UNIQUE CHECK (char_length(name) >= 4), " +
                "surname varchar(20) NOT NULL CHECK (char_length(surname) >= 5), " +
                "email VARCHAR(100) NOT NULL UNIQUE CHECK (email LIKE '_%@_%.%'), " +
                "birthday date NOT NULL, " +
                "created_by int, " +
                "created_at timestamp(6) DEFAULT CURRENT_TIMESTAMP, " +
                "last_login timestamp(6) DEFAULT CURRENT_TIMESTAMP, " +
                "password varchar(30) NOT NULL, " +
                "updated_by int, " +
                "bio varchar(255) NOT NULL);";

        String createPostsTable = "CREATE TABLE IF NOT EXISTS posts " +
                "(id SERIAL PRIMARY KEY, " +
                "user_id int NOT NULL, " +
                "title varchar(200) NOT NULL CHECK (char_length(title) >= 4), " +
                "view int DEFAULT 0, " +
                "created_at timestamp(3) DEFAULT CURRENT_TIMESTAMP, " +
                "created_by int NOT NULL, " +
                "updated_at timestamp(3) DEFAULT CURRENT_TIMESTAMP, " +
                "updated_by int, " +
                "post_like int DEFAULT 0, " +
                "FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE);";

        String createCommentsTable = "CREATE TABLE IF NOT EXISTS comments " +
                "(id SERIAL PRIMARY KEY, " +
                "post_id int NOT NULL, " +
                "user_id int NOT NULL, " +
                "content varchar(250) NOT NULL, " +
                "created_at timestamp(6) DEFAULT CURRENT_TIMESTAMP, " +
                "created_by int NOT NULL, " +
                "comment_like int DEFAULT 0, " +
                "FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE, " +
                "FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE);";
        try (Connection connection = JbdApp.connection();
             Statement stmt = connection.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.executeUpdate(createPostsTable);
            stmt.executeUpdate(createCommentsTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTable();
    }

}


