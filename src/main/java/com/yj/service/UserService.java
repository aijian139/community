package com.yj.service;

import com.yj.mapper.UserMapper;
import com.yj.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User findUserById(int id){
        User user = userMapper.selectById(id);
        return user;
    }

}
