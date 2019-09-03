package com.hzfy.library.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 便于管理所有Presenter的Disposable
 */
public abstract class BaseRxJavaPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }


    protected void dispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected abstract class OnceLoadingObserver<P> extends com.hzfy.library.common.loading.OnceLoadingObserver<P> {

        @Override
        public void onSubscribe(Disposable disposable) {
            super.onSubscribe(disposable);
            addDisposable(disposable);
        }

        @Override
        public void onError(Throwable throwable) {
            super.onError(throwable);
        }

        public OnceLoadingObserver(BaseView baseView, boolean cancelable) {
            super(baseView, cancelable);
        }

        public OnceLoadingObserver(BaseView baseView) {
            super(baseView);
        }
    }

    /**
     * 一次性观察者，无论回调哪个都结束观察
     */
    protected abstract class OnceObserver<Q> extends com.hzfy.library.common.rx.OnceObserver<Q> {
        @Override
        public void onSubscribe(Disposable disposable) {
            super.onSubscribe(disposable);
            addDisposable(disposable);
        }
    }


    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        dispose();
    }
}
