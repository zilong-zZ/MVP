package com.hzfy.library.common.rx;


import com.hzfy.library.data.BaseResult;
import com.hzfy.library.util.exception.RemoteServiceException;

import io.reactivex.functions.Function;

/**
 * 请求结果转换类
 * @param <T> 数据类型
 */
public class ResultFunction<T> implements Function<BaseResult<T>, T> {


    @Override
    public T apply(BaseResult<T> result) throws Exception {
        if (result == null) {
            throw new RemoteServiceException("获取数据为空");
        }
        if (!result.isSuccessful()) {
            RemoteServiceException remoteServiceException = new RemoteServiceException(result.getMessage());
            remoteServiceException.setCode(result.getCode());
            throw remoteServiceException;
        }
        //请求成功
        T t = result.getData();
        if (t == null) {
            //防止RxJava空指针
            t = (T) "";
        }
        return t;
    }
}
