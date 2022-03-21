package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    private static final String CREATE_TABLE = "CREATE TABLE Users (id SERIAL PRIMARY KEY, name VARCHAR(20),lastname VARCHAR(20),age INT)";
    private static final String DROP_TABLE = "DROP TABLE Users";
    private static final String SAVE_USER = "INSERT INTO Users(name,lastname,age) VALUES (?,?,?)";
    private static final String DELETE_BY_ID = "DELETE FROM Users WHERE id = ?";
    private static final String GET_USERS = "SELECT * FROM Users";
    private static final String CLEAN_TABLE = "TRUNCATE TABLE Users";

    Util util = new Util();

    public void createUsersTable() {

        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE)) {

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {

        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE)) {

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age)  {

        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                byte age = resultSet.getByte(4);
                users.add(new User(name, lastname, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {

        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CLEAN_TABLE)) {

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
