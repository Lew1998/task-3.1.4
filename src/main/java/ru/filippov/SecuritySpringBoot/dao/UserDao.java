package ru.filippov.SecuritySpringBoot.dao;


import ru.filippov.SecuritySpringBoot.model.User;

import java.util.List;


public interface UserDao {

    List<User> getAllUsers();
    User getUserById(long id);
    User getUserByEmail(String userName);
    void deleteById(long id);
    void add(User user);
    void update(User userUpdater);
}
