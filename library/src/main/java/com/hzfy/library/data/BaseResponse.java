package com.hzfy.library.data;

/**
 * 请求结果基类
 */
public class BaseResponse {

    private static final String CODE_SUCCESSFUL = "0";

    /**
     * ut失效
     */
    private static final String CODE_UNAUTHORIZED = "99";

    /**
     * 响应码
     */
    private String code;
    /**
     * 消息
     */
    private String message;


    /**
     * 是否请求成功
     */
    public boolean isSuccessful() {
        return CODE_SUCCESSFUL.equals(code);
    }


    /**
     * 请求失败时是否因为ut失效
     */
    public boolean isUnauthorized() {
        return !isSuccessful() && CODE_UNAUTHORIZED.equals(code);
    }


    public String getCode() {
        return code;
    }

    public BaseResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
