package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {
    }
    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user \n" +
                "(\n" +
                "    id BIGINT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    name VARCHAR(20),\n" +
                "    last_name VARCHAR(20),\n" +
                "    age TINYINT\n" +
                ");";
        try (Statement prep_statement = connection.createStatement()) {
            prep_statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String sqlDrop = "DROP TABLE IF EXISTS user";
        try (Statement pstatement = connection.createStatement()) {
            pstatement.executeUpdate(sqlDrop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String sqlSaveUser = "INSERT INTO user(name, last_name, age) Values (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSaveUser)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        String sqlRemoveUserById = "DELETE FROM user WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRemoveUserById)) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        String sqlGetAllUsers = "SELECT * FROM user";

        try (Statement preparedStatement = connection.createStatement()) {
            ResultSet rs = preparedStatement.executeQuery(sqlGetAllUsers);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("last_name"));
                user.setAge(rs.getByte("age"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        String sqlCleanUsersTable = "TRUNCATE user";
        try (Statement prepStatement = connection.createStatement()) {
            prepStatement.executeUpdate(sqlCleanUsersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
