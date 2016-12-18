package com.julianraj.mvpstartkit.di.module;

import android.content.Context;

import com.julianraj.mvpstartkit.MyApplication;
import com.julianraj.mvpstartkit.domain.executor.JobExecutor;
import com.julianraj.mvpstartkit.domain.executor.PostExecutionThread;
import com.julianraj.mvpstartkit.domain.executor.ThreadExecutor;
import com.julianraj.mvpstartkit.domain.executor.MainThread;
import com.julianraj.mvpstartkit.util.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final MyApplication mApplication;

    public ApplicationModule(MyApplication pApplication) {
        this.mApplication = pApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.mApplication;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(Context pContext) {
        return new PreferenceHelper(pContext);
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(MainThread mainThread) {
        return mainThread;
    }
}
