package com.niit.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Student {
    private  Integer id;
    private  String username;
    private  String avatar;
    private LocalDateTime createTime;

}
