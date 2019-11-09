package com.niit.web.blog.service;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.domain.UserDto;

import java.util.Map;

public interface UserService {

    /**
     * @param userDto
     * @return
     */
    Map<String, Object> signIn(UserDto userDto);

}
