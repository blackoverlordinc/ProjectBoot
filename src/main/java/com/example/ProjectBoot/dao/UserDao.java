package com.example.ProjectBoot.dao;


import com.example.ProjectBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    User show(int id);
    void update(int id, User updatedUser);
    void delete(int id);
}
