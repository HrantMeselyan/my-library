package com.example.authorBookServlet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {
    private static final DbConnectionProvider INSTANCE = new DbConnectionProvider();
    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mylibrray?useUnicode=true;characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private DbConnectionProvider() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static DbConnectionProvider getInstance() {
        return INSTANCE;
    }

}
