package com.hzfy.library.task;

import java.util.ArrayList;
import java.util.List;

public class TaskResult {

    private List<MyTask> mSuccessTaskList = new ArrayList<>();
    private List<MyTask> mFailureTaskList = new ArrayList<>();

    public boolean isAllSuccess() {
        return mFailureTaskList.isEmpty();
    }

    public List<MyTask> getSuccessTaskList() {
        return mSuccessTaskList;
    }

    public void setSuccessTaskList(List<MyTask> successTaskList) {
        mSuccessTaskList.clear();
        mSuccessTaskList.addAll(successTaskList);
    }

    public List<MyTask> getFailureTaskList() {
        return mFailureTaskList;
    }

    public void setFailureTaskList(List<MyTask> failureTaskList) {
        mFailureTaskList.clear();
        mFailureTaskList.addAll(failureTaskList);
    }
}
