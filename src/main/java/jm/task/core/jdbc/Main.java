package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        UserServiceImpl userService = new UserServiceImpl();
//
//        userService.createUsersTable();
//
//        userService.saveUser("Oleg", "Popov", (byte) 21);
//        userService.saveUser("Boris", "Ivanov", (byte) 23);
//        userService.saveUser("Ilya", "Petrov", (byte) 34);
//        userService.saveUser("German", "G", (byte) 56);
//
//        List<User> users = userService.getAllUsers();
//        users.forEach(System.out::println);
//
//        userService.cleanUsersTable();
//        userService.dropUsersTable();


        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ben", "Ivanov", (byte) 21);
        userService.saveUser("Anna", "Ivanova", (byte) 22);
        userService.saveUser("Patric", "Vasilev", (byte) 23);
        userService.saveUser("Stive", "Pupkin", (byte) 24);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

