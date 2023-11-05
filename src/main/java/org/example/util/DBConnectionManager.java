package org.example.util;

import java.sql.*;

public class DBConnectionManager {
    private static final String DATABASE_URL = "jdbc:postgresql://127.0.0.1:5555/postgres";
    private static final String DATABASE_PASSWORD = "padmin";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_DRIVER = "org.postgresql.Driver";
    static {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DBConnectionManager() {}
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }
}
