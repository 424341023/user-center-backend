package com.java.usercenterbackend.utils;

import com.java.usercenterbackend.common.BaseResponce;
import com.java.usercenterbackend.common.ErrorCode;

/**
 * 返回工具类
 *
 * @author rongguang
 * @version 1.0.0
 * @date 2024年03月11日 15:32:03
 * @packageName com.java.usercenterbackend.utils
 * @className ResultUtils
 */
public class ResultUtils {
    /**
     * 成功
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponce<T> success(T data) {
        return new BaseResponce<>(0, data, "ok");
    }

    /**
     * 失败
     * @param errorCode
     * @return
     * @param <T>
     */
    public static <T> BaseResponce<T> error(ErrorCode errorCode) {
        return new BaseResponce<>(errorCode);
    }
}
