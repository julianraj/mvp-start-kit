package com.julianraj.mvpstartkit.domain.interactor;

import android.os.Bundle;

import com.julianraj.mvpstartkit.data.api.ApiManager;
import com.julianraj.mvpstartkit.domain.executor.PostExecutionThread;
import com.julianraj.mvpstartkit.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class Interactor<T> {

    public final ApiManager mApiManager;
    private final ThreadExecutor mExecutor;
    private final PostExecutionThread mPostThread;
    private Subscription mSubscription = Subscriptions.empty();

    public Bundle params;

    protected Interactor(ApiManager apiManager, ThreadExecutor executor,
                         PostExecutionThread postThread){
        mApiManager = apiManager;
        mExecutor = executor;
        mPostThread = postThread;
    }

    protected abstract Observable<T> buildObservable();

    public void execute(Subscriber pSubscriber) {
        this.mSubscription = this.buildObservable()
                .subscribeOn(Schedulers.from(mExecutor))
                .observeOn(mPostThread.getScheduler(), true)
                .subscribe(pSubscriber);
    }

    public void setParams(Bundle params) {
        this.params = params;
    }

    public void unSubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
