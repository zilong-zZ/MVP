package com.hzfy.base.di.modules;

import com.hzfy.base.data.gank.local.GankLocalApi;
import com.hzfy.base.data.gank.local.IGankLocalApi;
import com.hzfy.base.data.gank.remote.GankRemoteApi;
import com.hzfy.base.data.gank.remote.GankRemoteService;
import com.hzfy.base.data.gank.remote.IGankRemoteApi;
import com.hzfy.library.di.ResultType;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class GankModule {

    @Provides
    @Singleton
    GankRemoteService provideTransactionRemoteService(@ResultType Retrofit retrofit) {
        //这里引用了ResultType的Retrofit实例
        return retrofit.create(GankRemoteService.class);
    }

    @Singleton
    @Provides
    IGankLocalApi provideTransactionLocalApi(GankLocalApi localApi) {
        return localApi;
    }

    @Singleton
    @Provides
    IGankRemoteApi provideTransactionRemoteApi(GankRemoteApi remoteApi) {
        return remoteApi;
    }
}
