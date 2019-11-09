package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    /**
     * 查看所有学生
     * @return
     * @throws SQLException
     */
    List<Student> selectAll() throws SQLException;

    /**
     *
     * @param studentList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Student> studentList)throws SQLException;
}
