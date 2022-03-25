package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

public class Util {

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "parol";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/katadb";

    public static Connection getConnection() throws SQLException {
        try (BasicDataSource ds = new BasicDataSource()) {
            ds.setUrl(DB_URL);
            ds.setUsername(DB_USERNAME);
            ds.setPassword(DB_PASSWORD);
            return ds.getConnection();
        }
    }

    private static final String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DIALECT = "org.hibernate.dialect.MySQL8Dialect";
    private static final String SHOW_SQL = "true";
    private static final String HBM2DLL = "create";
    private static final String CURRENT_SESSION = "thread";


    public static SessionFactory getSessionFactory() {

        Configuration config = new Configuration();
        config.setProperty("hibernate.connector.driver_class", DB_DRIVER_NAME);
        config.setProperty("hibernate.connection.url", DB_URL);
        config.setProperty("hibernate.connection.username", DB_USERNAME);
        config.setProperty("hibernate.connection.password", DB_PASSWORD);
        config.setProperty("hibernate.dialect", DIALECT);
        config.setProperty("hibernate.show_sql", SHOW_SQL);
        config.setProperty("hibernate.hbm2ddl.auto", HBM2DLL);
        config.setProperty("hibernate.current_session_context_class", CURRENT_SESSION);

        return config.addAnnotatedClass(User.class).buildSessionFactory();
    }
}

