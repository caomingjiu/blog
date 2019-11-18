package com.niit.web.blog.factory;

import com.niit.web.blog.dao.*;
import com.niit.web.blog.dao.impl.*;

public class DaoFactory {

    //    instanceshi实例
    public static StudentDao getStudentDaoInstance(){
        return new StudentDaoImpl();
    }
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
    public static JianshuDao getJianshuDaoInstance(){return  new JianshuDaoImpl();}
    public static Addressdao getAddressDaoInstance(){return  new AddressDaoImpl();}
    public static ArticleDao getArticleDaoInstance() { return  new ArticleDaoImpl(); }
}

