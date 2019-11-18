package com.niit.web.blog.service;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.domain.UserDto;
import com.niit.web.blog.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * @param userDto
     * @return
     */
    Map<String, Object> signIn(UserDto userDto);
    List<User> listUser();
}
