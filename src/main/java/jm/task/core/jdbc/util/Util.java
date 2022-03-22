package jm.task.core.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Util {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "parol";
    private static final String URL = "jdbc:mysql://localhost:3306/katadb";

    public static Connection getConnection() throws SQLException {
        try (BasicDataSource ds = new BasicDataSource()) {
            ds.setUrl(URL);
            ds.setUsername(USERNAME);
            ds.setPassword(PASSWORD);
            return ds.getConnection();
        }
    }
}

