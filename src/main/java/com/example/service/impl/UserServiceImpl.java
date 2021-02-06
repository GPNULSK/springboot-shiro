package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String username) {

        User user = new User();
        user.setUsername(username);
        user.setPassword("1");

        return userDao.login(username);
    }
}
