package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userImpl = new UserServiceImpl();
        List<User> list = new ArrayList<>();
        list.add(new User("Ilia", "Peshkur", (byte) 24));
        list.add(new User("Kirill", "Man", (byte) 22));
        list.add(new User("Kristina", "Izmailov", (byte) 20));
        list.add(new User("Jora", "Ivanov", (byte) 26));

        userImpl.createUsersTable();
        for (User user : list) {
            userImpl.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем - " + user.getName() + " добавлен в базу данных");
        }
        System.out.println(userImpl.getAllUsers());
        userImpl.removeUserById(4);
//        userImpl.cleanUsersTable();
//        userImpl.dropUsersTable();
//        Util.closeSessionFactory();


    }
}
