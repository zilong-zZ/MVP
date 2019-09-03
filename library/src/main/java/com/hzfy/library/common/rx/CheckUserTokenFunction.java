package com.hzfy.library.common.rx;


import com.hzfy.library.data.BaseResult;
import com.hzfy.library.util.exception.UnauthorizedException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class CheckUserTokenFunction<T> implements Function<BaseResult<T>, ObservableSource<BaseResult<T>>> {


    @Override
    public ObservableSource<BaseResult<T>> apply(BaseResult<T> baseResult) throws Exception {
        if (baseResult.isUnauthorized()) {
            return Observable.error(new UnauthorizedException());
        }
        return Observable.just(baseResult);
    }
}
