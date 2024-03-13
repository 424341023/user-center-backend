package com.java.usercenterbackend.common;

/**
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月11日 16:29:54
 * @packageName com.java.usercenterbackend.common
 * @className ErrorCode
 */
public enum ErrorCode {

    SUCCESS(0, "成功", ""),
    PARAMS_ERROR(40000, "请求参数错误", ""),
    PARAMS_NULL_ERROR(40001, "请求参数为空", ""),
    NOT_LOGIN(40100, "未登录", ""),
    NO_AUTH(40101, "未授权", ""),
    SYSTEM_ERROR(50000, "系统内部错误", ""),
    LOGOUT_ERROR(40102, "登出失败", "");

    /**
     * 状态码信息
     */
    private final int code;
    /**
     *状态码描述(详情)
     */
    private final String message;
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}


