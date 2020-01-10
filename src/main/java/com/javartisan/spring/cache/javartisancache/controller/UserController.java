package com.javartisan.spring.cache.javartisancache.controller;


import com.javartisan.spring.cache.javartisancache.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/login1")
    public String login1(@RequestParam(name = "username") String userName) {

        return userService.queryLoginTime1(userName);
    }

    @GetMapping("/user/login2")
    public String login2(@RequestParam(name = "username") String userName) {

        return userService.queryLoginTime2(userName);
    }

}
