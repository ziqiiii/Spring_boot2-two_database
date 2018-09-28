package com.ziqiiii.demo.controller;

import com.ziqiiii.demo.dao.IUserDao;
import com.ziqiiii.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    IUserDao iUserDao;

    @RequestMapping("/test_ziqi")
    public User index(){
        User user = iUserDao.findByName("a");
        System.out.println(user.toString());
        return  user;
    }
}
