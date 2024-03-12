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
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponce<T> success(T data) {
        return new BaseResponce<>(0, data, "ok");
    }


    /**失败
     *
     * @param errorCode
     * @return
     */

    public static BaseResponce error(ErrorCode errorCode) {
        return new BaseResponce<>(errorCode);
    }
    /**
     失败
     *
     * @param errorCode
     * @param message
     * @param description
     * @return
     */
    public static BaseResponce error(ErrorCode errorCode, String message, String description) {
        return new BaseResponce<>(errorCode.getCode(), null, message, description);
    }

    /**失败
     *
     * @param code
     * @param message
     * @param description
     * @return
     */
    public static BaseResponce error(int code, String message, String description) {
        return new BaseResponce<>(code,null, message, description);
    }

    /**失败
     *
     * @param errorCode
     * @param description
     * @return
     */
    public static BaseResponce error(ErrorCode errorCode, String description) {
        return new BaseResponce<>(errorCode.getCode(), null, errorCode.getMessage(), description);
    }
}
