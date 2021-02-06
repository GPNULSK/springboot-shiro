package com.example.service;

import com.example.domain.User;
import org.apache.shiro.SecurityUtils;

public interface IUserService {

    User login(String username);

}
