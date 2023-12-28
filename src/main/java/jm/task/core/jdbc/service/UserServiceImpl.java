package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl example = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() {
        example.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        example.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        example.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        example.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return example.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        example.cleanUsersTable();
    }
}
