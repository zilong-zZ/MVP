package com.hzfy.library.data;

/**
 * 请求结果基类
 * @param <T> 数据类型
 */
public class BaseResult<T> extends BaseResponse {

    /**
     * 数据
     */
    private T data;

    public T getData() {
        return data;
    }

    public BaseResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
