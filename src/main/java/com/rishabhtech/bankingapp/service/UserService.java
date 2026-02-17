package com.rishabhtech.bankingapp.service;

import com.rishabhtech.bankingapp.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void createUser(User user);
}
