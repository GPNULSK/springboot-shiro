package com.example.controller;

import com.example.domain.User;
import com.example.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public void login(String username,String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!");
        }catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping("/user")
    public User find(String username){
        return userService.login(username);
    }
}
