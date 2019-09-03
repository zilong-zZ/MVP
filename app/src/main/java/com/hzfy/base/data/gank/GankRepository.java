package com.hzfy.base.data.gank;

import android.support.annotation.NonNull;

import com.hzfy.base.data.gank.local.IGankLocalApi;
import com.hzfy.base.data.gank.remote.IGankRemoteApi;
import com.hzfy.base.data.gank.result.TodayResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

import static com.hzfy.library.util.Preconditions.checkNotNull;

@Singleton
public class GankRepository implements IGankLocalApi, IGankRemoteApi {

    private IGankLocalApi mLocalApi;
    private IGankRemoteApi mRemoteApi;

    @Inject
    public GankRepository(@NonNull IGankLocalApi localApi,
                                 @NonNull IGankRemoteApi remoteApi) {
        mLocalApi = checkNotNull(localApi);
        mRemoteApi = checkNotNull(remoteApi);
    }
    
    @Override
    public Observable<TodayResult> getTodayInfo() {
        return mRemoteApi.getTodayInfo();
    }
}
