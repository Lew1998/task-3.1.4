package ru.filippov.SecuritySpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.filippov.SecuritySpringBoot.dao.UserDao;
import ru.filippov.SecuritySpringBoot.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void add(User user) {
        userDao.add(user);
    }


    @Override
    public List<User> listUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public User getUserByEmail(String userName) {
        return userDao.getUserByEmail(userName);
    }

    @Override
    public void update(User userUpdater) {

        userDao.update(userUpdater);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }


}
