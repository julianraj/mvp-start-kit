package com.julianraj.mvpstartkit.di.module;

import com.julianraj.mvpstartkit.data.api.ApiManager;
import com.julianraj.mvpstartkit.di.PerActivity;
import com.julianraj.mvpstartkit.domain.executor.PostExecutionThread;
import com.julianraj.mvpstartkit.domain.executor.ThreadExecutor;
import com.julianraj.mvpstartkit.domain.interactor.Interactor;
import com.julianraj.mvpstartkit.domain.interactor.TestInteractor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    Long mId;

    public DataModule(Long id) {
        mId = id;
    }

    @Provides
    @PerActivity
    @Named("test")
    Interactor provideTestInterator(ApiManager apiManager, ThreadExecutor executor,
                                    PostExecutionThread postThread) {
        return new TestInteractor(mId, apiManager, executor, postThread);
    }
}
