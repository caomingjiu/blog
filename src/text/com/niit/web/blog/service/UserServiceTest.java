package com.niit.web.blog.service;

import com.niit.web.blog.domain.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13941810179", "55113afc84e77cfabaf8fbb650aa12ac");
        Map<String, Object> map = userService.signIn(userDto);
        System.out.println(map);
    }
}