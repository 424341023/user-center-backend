package com.java.usercenterbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.usercenterbackend.common.BaseResponce;
import com.java.usercenterbackend.model.domain.User;
import com.java.usercenterbackend.model.domain.request.UserLoginRequest;
import com.java.usercenterbackend.model.domain.request.UserRegisterRequest;
import com.java.usercenterbackend.service.UserService;
import com.java.usercenterbackend.utils.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.RouterFunctionDslKt;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.java.usercenterbackend.constant.UserConstant.ADMIN_ROLE;
import static com.java.usercenterbackend.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月09日 20:18:03
 * @packageName com.java.usercenterbackend.controller
 * @className UserController
 */

/**
 * 用户接口
 *
 * @author rongguang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponce<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }

        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String planetCode = userRegisterRequest.getPlanetCode();

        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, planetCode)) {
            return null;
        }
        Long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        return ResultUtils.success(result);

    }

    @PostMapping("/login")
    public BaseResponce<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }

        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();

        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        User user = userService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(user);

    }

    @PostMapping("/logout")
    public BaseResponce<Integer> userLogout(@RequestBody HttpServletRequest request) {
        if(request== null){
            return null;
        }
        int result = userService.userLogout(request);
        return ResultUtils.success(result);
    }

    /**
     * 获取当前用户信息
     * @param request
     * @return
     */
    @GetMapping("/current")
    public BaseResponce<User> getCurrentUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null) {
            return null;
        }
        Long userId = currentUser.getId();
        // TODO 校验用户是否合法
        User user = userService.getById(userId);
        User safetyUser = userService.getSafetyUser(user);
        return ResultUtils.success(safetyUser);
    }

    @GetMapping("/search")
    public BaseResponce<List<User>> searchUsers(String username, HttpServletRequest request) {
        if (!isAdmin(request)) {
            return null;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("username", username);
        }
        List<User> userList = userService.list(queryWrapper);
        List<User> list = userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
        return ResultUtils.success(list);
    }

    @PostMapping("/delete")
    public BaseResponce<Boolean> deleteUser(@RequestBody Long id, HttpServletRequest request) {
        if (!isAdmin(request)) {
            return null;
        }

        if (id <= 0) {
            return null;
        }
        boolean b = userService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 判断是否为管理员
     *
     * @param request
     * @return
     */
    private boolean isAdmin(HttpServletRequest request) {
        // 仅管理员可查询
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        return user != null && user.getUserRole() == ADMIN_ROLE;
    }
}
