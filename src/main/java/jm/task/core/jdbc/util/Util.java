package jm.task.core.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    String USERNAME = "root";
    String PASSWORD = "parol";
    String URL = "jdbc:mysql://localhost:3306/katadb";

    BasicDataSource ds = new BasicDataSource();

    private void connectDataBase() {
        ds.setUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
    }

    public Connection getConnection() throws SQLException {
        connectDataBase();
        return ds.getConnection();
    }
}

