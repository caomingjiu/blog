package com.niit.web.blog.factory;

import com.niit.web.blog.dao.StudentDao;
import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.dao.impl.StudentDaoImpl;
import com.niit.web.blog.dao.impl.UserDaoImpl;

public class DaoFactory {

    //    instanceshi实例
    public static StudentDao getStudentDaoInstance(){
        return new StudentDaoImpl();
    }


    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
}
