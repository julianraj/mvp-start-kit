package com.julianraj.mvpstartkit.domain.executor;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

public class MainThread implements PostExecutionThread {
    @Inject
    public MainThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
