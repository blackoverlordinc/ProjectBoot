package com.example.ProjectBoot.service;
//убрал импорты
import com.example.ProjectBoot.dao.UserDao;
import com.example.ProjectBoot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
         userDao.addUser(user);
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }


}
