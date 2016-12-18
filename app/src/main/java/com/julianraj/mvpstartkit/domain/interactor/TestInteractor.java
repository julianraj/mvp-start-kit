package com.julianraj.mvpstartkit.domain.interactor;

import com.julianraj.mvpstartkit.data.api.ApiManager;
import com.julianraj.mvpstartkit.domain.executor.PostExecutionThread;
import com.julianraj.mvpstartkit.domain.executor.ThreadExecutor;
import com.julianraj.mvpstartkit.models.TestModel;

import javax.inject.Inject;

import rx.Observable;

public class TestInteractor extends Interactor<TestModel> {

    private final Long mId;

    @Inject
    public TestInteractor(Long id, ApiManager apiManager, ThreadExecutor executor,
                          PostExecutionThread postThread) {
        super(apiManager, executor, postThread);
        mId = id;
    }

    @Override
    protected Observable<TestModel> buildObservable() {
        if(mId != null){
            return mApiManager.getTestModel(mId);
        }
        throw new IllegalStateException("Required id parameter is not provided.");
    }
}
