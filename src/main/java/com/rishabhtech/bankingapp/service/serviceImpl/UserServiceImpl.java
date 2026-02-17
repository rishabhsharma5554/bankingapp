package com.rishabhtech.bankingapp.service.serviceImpl;

import com.rishabhtech.bankingapp.model.entity.User;
import com.rishabhtech.bankingapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        log.info("Fetching users...");
        return users;
    }

    public void createUser(User user)
    {
        log.info("Creating user...");
        users.add(user);
    }
}
