package com.hzfy.base.base;

import com.hzfy.base.application.AndroidApplication;
import com.hzfy.base.di.components.ApplicationComponent;
import com.hzfy.base.di.components.DaggerServiceComponent;
import com.hzfy.base.di.components.ServiceComponent;

public abstract class BaseService<T extends BasePresenter> extends com.hzfy.library.base.BaseService<T> implements BaseView {

    private ApplicationComponent getApplicationComponent() {
        return AndroidApplication.getAndroidApplication().getApplicationComponent();
    }


    protected ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();
    }
}
