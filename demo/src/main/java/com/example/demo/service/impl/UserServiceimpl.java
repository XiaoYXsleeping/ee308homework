package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl extends ServiceImpl<UserMapper, User> implements UserService {
@Resource
@Autowired
private UserMapper userMapper;
    @Override
    public List<User> listAll(){
return userMapper.listAll();


    }

}
