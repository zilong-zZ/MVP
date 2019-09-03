package com.hzfy.base.base;

import com.hzfy.base.application.AndroidApplication;
import com.hzfy.base.di.components.ActivityComponent;
import com.hzfy.base.di.components.ApplicationComponent;
import com.hzfy.base.di.components.DaggerActivityComponent;
import com.hzfy.base.di.modules.ActivityModule;

/**
 * BaseActivity for every Activity in this application.
 */

public abstract class EmptyActivity extends com.hzfy.library.base.EmptyActivity {

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
