package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;


import com.example.demo.entity.User;
import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;


import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@ResponseBody
public class hello {
    @GetMapping
    public String hello() { return "hello";}


    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(){


        return userService.listAll();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user);

    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);

    }
    //查询
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user){
      LambdaQueryWrapper <User> lambdaQueryWrapper =new LambdaQueryWrapper();
      if (StringUtils.isNotBlank(user.getName())){
          lambdaQueryWrapper.eq(User::getName,user.getName());
      }


        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody HashMap map){
        System.out.println(map);
        return null;
    }







}
