package com.hzfy.library.base;

import com.hzfy.library.util.schedulers.ISchedulerProvider;

import javax.inject.Inject;

/**
 * BaseActivity for every Activity in this application.
 */

public abstract class EmptyActivity extends BaseActivity<EmptyPresenter> implements EmptyContract.View {
    @Inject
    protected ISchedulerProvider mSchedulerProvider;
}
