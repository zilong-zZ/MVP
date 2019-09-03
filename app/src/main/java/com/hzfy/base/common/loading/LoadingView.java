package com.hzfy.base.common.loading;


import android.app.Activity;
import android.content.Context;

import com.hzfy.base.R;
import com.hzfy.library.common.loading.ILoadingView;
import com.hzfy.library.di.ActivityScope;

import javax.inject.Inject;

/**
 * 实现提示加载中Dialog {@link ILoadingView}
 */
@ActivityScope
public class LoadingView implements ILoadingView {

    private Context mContext;
    private LoadingDialog mLoadingDialog;
    private final Object mObject = new Object();

    @Inject
    public LoadingView(Activity activity) {
        mContext = activity;
        init();
    }

    private void init() {
        mLoadingDialog = new LoadingDialog(mContext, R.style.Loading_Dialog);
    }

    @Override
    public void showLoading(boolean cancelable) {
        if (mLoadingDialog != null) {
            synchronized (mObject) {
                if (mLoadingDialog.isShowing()) {
                    hideLoading();
                }
                init();
                mLoadingDialog.show();
            }
        }
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public boolean isShowing() {
        return mLoadingDialog != null && mLoadingDialog.isShowing();
    }

}
