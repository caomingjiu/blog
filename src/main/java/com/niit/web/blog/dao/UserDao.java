package com.niit.web.blog.dao;


import com.niit.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**II
     *
     * @param userList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<User> userList)throws SQLException;
    /**
     * 根据手机号查找用户
     * @param mobile
     * @return
     * @throws SQLException
     */
    User findUserByMobile(String mobile) throws SQLException;

    /**
     * 根据手机号查询文章
     * @param mobile
     * @return
     * @throws SQLException
     */
    User findUserIntroduction(String mobile)throws SQLException;
    /**
     * 查看所有学生
     * @return
     * @throws SQLException
     */
    List<User> selectAll() throws SQLException;
}
