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

    @Test
    void userRegister() {
        // 空值
        String userAccount = "zongcc";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // userAccount长度小于4
        userAccount = "zon";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // userPassword长度小于8
        userAccount = "zongcc";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 包含特殊字符
        userAccount = "zongc*c";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 前后密码不一致
        userAccount = "zongcc";
        userPassword = "123456789";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 该用户名已经被注册
        userAccount = "zongcai";
        userPassword = "123456789";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 注册成功
        userAccount = "zongcai111";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result > 0);

    }
}