package com.niit.web.blog.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Jianshu {
    private long id;
    private String mobile;
    private String password;
    private String writer;
    private String title;
    private String text;
    private String avatar;
    private String message;
    private String attention;
    private LocalDateTime createTime;
}
