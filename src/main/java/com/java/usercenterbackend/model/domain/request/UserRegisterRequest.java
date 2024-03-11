package com.java.usercenterbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月09日 20:28:39
 * @packageName com.java.usercenterbackend.model.domain.request
 * @className UserRegisterRequest
 */
@Data
public class UserRegisterRequest implements Serializable {

    public static final long serialVersionUID = 3191210270628675084L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
