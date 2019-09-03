package com.hzfy.base.base;


import com.hzfy.base.application.AndroidApplication;
import com.hzfy.base.di.components.ApplicationComponent;
import com.hzfy.base.di.components.DaggerFragmentComponent;
import com.hzfy.base.di.components.FragmentComponent;
import com.hzfy.base.di.modules.FragmentModule;

/**
 * BaseFragment for every Fragment in this application.
 */

public abstract class EmptyFragment extends com.hzfy.library.base.EmptyFragment {
    protected ApplicationComponent getApplicationComponent() {
        return AndroidApplication.getAndroidApplication().getApplicationComponent();
    }


    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }
}
