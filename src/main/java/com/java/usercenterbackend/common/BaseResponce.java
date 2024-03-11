package com.java.usercenterbackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月11日 15:24:17
 * @packageName com.java.usercenterbackend.common
 * @className BaseResponce
 */

@Data
public class BaseResponce<T> implements Serializable {
    private int code;

    private T data;

    private String message;

    public BaseResponce(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponce(int code, T data) {
        this(code, data, "");
    }

}
