package com.niit.web.blog.dao;


import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class JianshuDaoTest {
    private JianshuDao jianshuDao= DaoFactory.getJianshuDaoInstance();
    private static Logger logger= LoggerFactory.getLogger(UserDaoTest.class);
    @Test
    public void batchInsert() {
        try {
            int[] result=jianshuDao.batchInsert(JSoupSpider.getJianshu());
            if(result.length!=0){
                logger.info("批量新增用户成功");
            }else {
                logger.error("批量新增用户失败");
            }
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }
}