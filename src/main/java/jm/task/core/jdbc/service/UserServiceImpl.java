package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {
    UserDaoJDBCImpl example = new UserDaoJDBCImpl();

    public void createUsersTable() {
        example.createUsersTable();
    }

    public void dropUsersTable() {
        example.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        example.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        example.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return example.getAllUsers();
    }

    public void cleanUsersTable() {
        example.cleanUsersTable();
    }
}
