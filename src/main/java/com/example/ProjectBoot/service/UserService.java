package com.example.ProjectBoot.service;


import com.example.ProjectBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    User show(int id);
    void update(int id, User updatedUser);
    void delete(int id);
}
