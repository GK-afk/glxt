package com.wxbj.bjgl.controller;

//import com.wxbj.bjgl.dao.UserDao;

import com.wxbj.bjgl.entity.User;
import com.wxbj.bjgl.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class UserController {

   @Resource
   private IUserService IUserService;

    @PostMapping("/login")
        public ResponseEntity<User> login(@RequestBody  User user){
        User login = IUserService.login(user);
        System.out.println(login);
        if (login!=null){
            return ResponseEntity.ok(login);
        }
       return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(null);
    }

}
