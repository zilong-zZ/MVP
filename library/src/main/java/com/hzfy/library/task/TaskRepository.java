package com.hzfy.library.task;

import android.support.annotation.NonNull;

import com.hzfy.library.common.rx.BaseObserver;
import com.hzfy.library.util.StringUtils;
import com.hzfy.library.util.schedulers.ISchedulerProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import static com.hzfy.library.util.Preconditions.checkNotNull;


@Singleton
public class TaskRepository {

    private ISchedulerProvider mSchedulerProvider;

    private Map<String, MyTask> mTaskList = new HashMap<>();
    /**
     * 优先进行的任务列表
     */
    private List<MyTask> mPreferentialTaskList = new ArrayList<>();
    /**
     * 稍后进行的任务列表
     */
    private List<MyTask> mLaterTaskList = new ArrayList<>();

    private Disposable mTimerTaskDisposable;

    private int taskCount;
    private int taskCompleteCount = 0;

    private Callback mCallback;


    private List<MyTask> mSuccessTaskList = new ArrayList<>();
    private List<MyTask> mFailureTaskList = new ArrayList<>();


    @Inject
    public TaskRepository(@NonNull ISchedulerProvider schedulerProvider) {
        mSchedulerProvider = checkNotNull(schedulerProvider, "schedulerProvider cannot be null");
    }


    public void addTask(MyTask task) {
        checkNotNull(task, "task cannot be null");
        if (mTaskList.containsKey(task.getTaskTag())) {
            return;
        }
        task.setCallback(new MyTask.Callback() {

            @Override
            public void onStart(MyTask task) {
                onTaskStart(task);
            }
            @Override
            public void onComplete(MyTask task) {
                onTaskComplete(task);
            }
        });
        mTaskList.put(task.getTaskTag(), task);
    }

    private void onTaskStart(MyTask task) {
        if (mCallback != null) {
            mCallback.onStart(task);
        }
    }

    private void onTaskComplete(MyTask task) {
        if (mCallback != null) {
            mCallback.onComplete(task);
        }
        taskCompleteCount++;
        if (task.isFailing()) {
            mFailureTaskList.add(task);
        } else {
            mSuccessTaskList.add(task);
        }

        checkLaterTask(task);

        checkAllComplete();
    }

    private void checkLaterTask(MyTask task) {
        for (MyTask laterTask : mLaterTaskList) {
            if (StringUtils.equals(task.getTaskTag(), laterTask.getTaskTag())) {
                if (task.isFailing()) {
                    //如果当前task失败了，则laterTask不执行，直接取消,递归下去
                    laterTask.cancel();
                } else {
                    //如果当前task成功了，则直接开始下个任务
                    laterTask.start();
                }
            }
        }
    }

    private void checkAllComplete() {
        if (isAllTaskComplete()) {
            if (mCallback != null) {
                TaskResult result = new TaskResult();
                result.setSuccessTaskList(mSuccessTaskList);
                result.setFailureTaskList(mFailureTaskList);
                mCallback.onAllComplete(result);
            }
        }
    }


    public void startAll() {
        startAll(null);
    }

    public void startAll(Callback callback) {
        resetAll();

        mCallback = callback;

        for (MyTask task : mPreferentialTaskList) {
            task.start();
        }
    }

    private void resetAll() {
        cancelAll();

        mSuccessTaskList.clear();
        mFailureTaskList.clear();
        mPreferentialTaskList.clear();
        mLaterTaskList.clear();
        taskCount = mTaskList.size();
        for (Map.Entry<String, MyTask> taskEntry : mTaskList.entrySet()) {
            MyTask task = taskEntry.getValue();
            if (task.isLater()) {
                mLaterTaskList.add(task);
            } else {
                mPreferentialTaskList.add(task);
            }
        }
        taskCompleteCount = 0;
    }


    private boolean isAllTaskComplete() {
        return taskCompleteCount == taskCount;
    }

    public void startTimerTask(long delay, long period) {
        startTimerTask(delay, period, null);
    }

    public void startTimerTask(long delay, long period, final Callback callback) {
        cancelTimerTask();

        getIntervalDelayObservable(delay, period)
                .subscribe(new BaseObserver<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mTimerTaskDisposable = d;
                    }

                    @Override
                    public void onNext(Long aLong) {
                        startAll(callback);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }


    public void cancelTimerTask() {
        if (mTimerTaskDisposable != null && !mTimerTaskDisposable.isDisposed()) {
            mTimerTaskDisposable.dispose();
        }
        cancelAll();
    }

    public void cancelAll() {
        for (Map.Entry<String, MyTask> taskEntry : mTaskList.entrySet()) {
            taskEntry.getValue().cancel();
        }
    }


    private Observable<Long> getIntervalDelayObservable(long delay, long period) {
        return Observable.interval(delay, period, TimeUnit.SECONDS)
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.io());
    }

    public abstract static class Callback {

        public void onStart(MyTask task) {

        }

        public void onSuccess(MyTask task) {

        }

        public void onComplete(MyTask task) {

        }

        public abstract void onAllComplete(TaskResult result);
    }

}
