package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserDao {

    User login(String username);
}