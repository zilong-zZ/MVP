package com.hzfy.library.base;

import com.hzfy.library.util.schedulers.ISchedulerProvider;

import javax.inject.Inject;

/**
 * BaseFragment for every Fragment in this application.
 */

public abstract class EmptyDialogFragment extends BaseDialogFragment<EmptyPresenter> implements EmptyContract.View {
    @Inject
    protected ISchedulerProvider mSchedulerProvider;
}
