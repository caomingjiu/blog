package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.Addressdao;
import com.niit.web.blog.entity.Address;
import com.niit.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements Addressdao {
    @Override
    public int[] batchInsert(List<Address> addressList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_address (address) VALUES (?) ";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        addressList.forEach(address -> {
            try {
                pstmt.setString(1, address.getAddress());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        int[] result=pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null,pstmt,connection);
        return result;
    }
}
