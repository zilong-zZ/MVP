package com.hzfy.base.data.gank.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.hzfy.library.data.BaseLocalApi;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.hzfy.library.util.Preconditions.checkNotNull;


@Singleton
public class GankLocalApi extends BaseLocalApi implements IGankLocalApi {

    private Context mContext;

    @Inject
    public GankLocalApi(@NonNull Context context) {
        mContext = checkNotNull(context, "context cannot be null");
    }

}
