package com.java.usercenterbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月09日 20:35:53
 * @packageName com.java.usercenterbackend.model.domain.request
 * @className UserLoginRequest
 */
@Data
public class UserLoginRequest implements Serializable {
    public static final long serialVersionUID = 3390466589133763799L;

    private String userAccount;

    private String userPassword;

}
