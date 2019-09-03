package com.hzfy.library.base;

import android.app.Service;

import com.hzfy.library.util.rxbus.RxBusUtil;

import javax.inject.Inject;

public abstract class BaseService<T extends BasePresenter> extends Service implements BaseView {
    @Inject
    protected T mPresenter;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        RxBusUtil.register(this);
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        RxBusUtil.unRegister(this);
    }

    protected abstract void initInjector();

    @Override
    public void showNetWorkError() {
        //ignore
    }

    @Override
    public void showMessage(String message) {
        //ignore
    }

    @Override
    public void showLoadingDialog(boolean cancelable) {
        //ignore
    }

    @Override
    public void hideLoadingDialog() {
        //ignore
    }

    @Override
    public void closeCurrentPage() {
        stopSelf();
    }
}
