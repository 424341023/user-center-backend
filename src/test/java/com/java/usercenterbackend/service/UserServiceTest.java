package com.java.usercenterbackend.service;

import com.java.usercenterbackend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月09日 10:56:36
 * @packageName com.java.usercenterbackend.service
 * @className UserServiceTest
 */

@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {

        User user = new User();
        user.setUsername("dogYupi");
        user.setUserAccount("123");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        user.setPlanetCode("");

       boolean result = userService.save(user);

        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

}