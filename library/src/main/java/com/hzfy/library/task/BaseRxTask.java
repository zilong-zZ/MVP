package com.hzfy.library.task;

public abstract class BaseRxTask extends MyTask {


    @Override
    protected void startTask() {
        cancelTask();
        run();
    }

    protected abstract void run();

    protected abstract void dispose();

    @Override
    protected void cancelTask() {
        dispose();
    }


}
