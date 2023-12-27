package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        List<User> list = new ArrayList<>();
        list.add(new User("Ilia", "Peshkur", (byte) 24));
        list.add(new User("Kirill", "Man", (byte) 22));
        list.add(new User("Kristina", "Izmailov", (byte) 20));
        list.add(new User("Jora", "Ivanov", (byte) 26));

        userDao.createUsersTable();
        for (User user : list) {
            userDao.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем - " + user.getName() + " добавлен в базу данных");
        }
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

    }
}
