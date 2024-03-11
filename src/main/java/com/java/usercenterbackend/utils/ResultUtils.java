package com.java.usercenterbackend.utils;

import com.java.usercenterbackend.common.BaseResponce;

/**
 * 返回工具类
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月11日 15:32:03
 * @packageName com.java.usercenterbackend.utils
 * @className ResultUtils
 */
public class ResultUtils {
    public static <T> BaseResponce<T> success(T data){
        return new BaseResponce<>(0, data, "ok");
    }
}
