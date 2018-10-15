package com.javartisan.spring.cache.javartisancache.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {


    private String id = new SimpleDateFormat("HH:mm:ss").format(new Date());

    public String getId() {
        return id;
    }

}
