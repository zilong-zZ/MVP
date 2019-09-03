package com.hzfy.base.data.gank.remote;

import com.hzfy.base.data.app.IApplicationRepository;
import com.hzfy.base.data.gank.result.TodayResult;
import com.hzfy.library.data.BaseRemoteApi;
import com.hzfy.library.util.handler.IJsonHandler;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

import static com.hzfy.library.util.Preconditions.checkNotNull;

@Singleton
public class GankRemoteApi extends BaseRemoteApi implements IGankRemoteApi {

    private static final String TAG = "GankRemoteApi";


    private GankRemoteService mRemoteService;
    private IApplicationRepository mApplicationRepository;
    private IJsonHandler mJsonHandler;

    @Inject
    public GankRemoteApi(GankRemoteService transactionRemoteService,
                         IApplicationRepository applicationRepository,
                         IJsonHandler jsonHandler) {
        mRemoteService = checkNotNull(transactionRemoteService);
        mApplicationRepository = checkNotNull(applicationRepository);
        mJsonHandler = checkNotNull(jsonHandler);
    }

    @Override
    public Observable<TodayResult> getTodayInfo() {
        return mRemoteService.getTodayInfoList();
    }
}
