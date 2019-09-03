package com.hzfy.base.base;

import android.os.Bundle;

import com.hzfy.base.application.AndroidApplication;
import com.hzfy.base.di.components.ActivityComponent;
import com.hzfy.base.di.components.ApplicationComponent;
import com.hzfy.base.di.components.DaggerActivityComponent;
import com.hzfy.base.di.modules.ActivityModule;


/**
 * BaseActivity for every Activity in this application.
 */
public abstract class BaseActivity<T extends BasePresenter> extends com.hzfy.library.base.BaseActivity<T> implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ApplicationComponent getApplicationComponent() {
        return AndroidApplication.getAndroidApplication().getApplicationComponent();
    }


    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
