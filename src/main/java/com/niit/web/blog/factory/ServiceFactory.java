package com.niit.web.blog.factory;

import com.niit.web.blog.dao.impl.StudentServiceImpl;
import com.niit.web.blog.service.StudentService;
import com.niit.web.blog.service.UserService;
import com.niit.web.blog.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static StudentService getStudentServiceInstance(){
        return new StudentServiceImpl();
    }
    public static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }
}
