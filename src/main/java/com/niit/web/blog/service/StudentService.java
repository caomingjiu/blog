package com.niit.web.blog.service;

import com.niit.web.blog.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 浏览所有学生信息
     * @return
     */
    List<Student> listStudent();
}
