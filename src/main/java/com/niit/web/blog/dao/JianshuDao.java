package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Jianshu;
import java.sql.SQLException;
import java.util.List;

public interface JianshuDao {

    /**
     *
     * @param userList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Jianshu> userList)throws SQLException;
    /**
     * 根据手机号查找用户
     * @param mobile
     * @return
     * @throws SQLException
     */
    Jianshu findUserByMobile(String mobile) throws SQLException;
}
