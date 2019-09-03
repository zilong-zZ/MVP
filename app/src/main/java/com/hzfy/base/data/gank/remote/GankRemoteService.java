package com.hzfy.base.data.gank.remote;


import com.hzfy.base.data.gank.result.TodayResult;


import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.http.GET;


@Singleton
public interface GankRemoteService {

    /**
     * 获取最新一天
     */
    @GET("api/today")
    Observable<TodayResult> getTodayInfoList();
}
