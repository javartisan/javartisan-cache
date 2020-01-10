package com.javartisan.spring.cache.javartisancache.service;


import com.javartisan.spring.cache.javartisancache.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {

    //缓存配置参考:https://www.cnblogs.com/fashflying/p/6908028.html


    @Cacheable(value = "cache1", key = "#userName")
    public String queryLoginTime1(String userName) {

        System.out.println("6666666");
        return "queryLoginTime1 : " + new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    //默认不设置前缀的话，使用value作为前缀；设置前缀的话则使用设置前缀
    @Cacheable(value = "cache2", key = "#p0")
    public String queryLoginTime2(String userName) {

        return "queryLoginTime2 : " + new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    @Cacheable(value = "find1", key = "#user.id")
    public User find1(User user) {

        return new User();

    }


    @Cacheable(value = "find2", key = "#p0.id")
    public User find2(User user) {

        return new User();

    }
}
