package com.hzfy.base.di.modules;

import android.content.Context;

import com.hzfy.library.common.http.OkHttpFactory;
import com.hzfy.library.common.http.RetrofitFactory;
import com.hzfy.library.di.ResultType;
import com.hzfy.library.di.StringType;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 网络框架
 */
@Module
public class HttpModule {

    private final String baseUrl;
    private final boolean isDebug;

    public HttpModule(String baseUrl, boolean isDebug) {
        this.baseUrl = baseUrl;
        this.isDebug = isDebug;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Context context) {
        return OkHttpFactory.create(context, isDebug).newBuilder()
                .connectTimeout(20L, TimeUnit.SECONDS)
                .writeTimeout(20L, TimeUnit.SECONDS)
                .readTimeout(20L, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @ResultType //表示直接返回对象类型
    @Singleton
    Retrofit provideResultRetrofit(OkHttpClient okHttpClient) {
        return RetrofitFactory.createGsonWithRxJavaRetrofit(baseUrl, okHttpClient);
    }

    @Provides
    @StringType //表示返回Json String类型
    @Singleton
    Retrofit provideStringRetrofit(OkHttpClient okHttpClient) {
        return RetrofitFactory.createStringWithRxJavaRetrofit(baseUrl, okHttpClient);
    }

}
