package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface Addressdao {
    /**
     *
     * @param userList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Address> userList)throws SQLException;
}
