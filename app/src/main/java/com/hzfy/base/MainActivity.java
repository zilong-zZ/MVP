package com.hzfy.base;

import android.widget.TextView;

import com.hzfy.base.base.EmptyActivity;
import com.hzfy.base.data.gank.GankRepository;
import com.hzfy.base.data.gank.result.TodayResult;
import com.hzfy.library.util.LogUtil;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends EmptyActivity {

    @Inject
    GankRepository gankRepository;
    @BindView(R.id.text)
    TextView text;

    @Override
    protected void initInjector() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {
        getTestData();
    }

    private void getTestData() {
        gankRepository.getTodayInfo()
                .subscribeOn(mSchedulerProvider.io())//接口调用发生在io线程
                .observeOn(mSchedulerProvider.ui())//接口回调发生在ui线程
                .subscribe(new OnceLoadingObserver<TodayResult>(this) {
                    @Override
                    protected void onResponse(TodayResult result) {
                        //如果请求成功
                        setTestData(result);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        super.onError(throwable);
                    }
                });
    }

    private void setTestData(TodayResult result) {
        LogUtil.d("szl", result.toString());
        text.setText(result.toString());
    }

}
