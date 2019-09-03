package com.hzfy.library.base;

import javax.inject.Inject;

/**
 * 空
 */

public class EmptyPresenter implements EmptyContract.Presenter {


    @Inject
    public EmptyPresenter() {

    }

    @Override
    public void attachView(EmptyContract.View view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void onStart() {

    }


}
