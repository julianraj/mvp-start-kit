package com.julianraj.mvpstartkit.di.component;

import android.content.Context;

import com.julianraj.mvpstartkit.base.BaseActivity;
import com.julianraj.mvpstartkit.di.module.ApplicationModule;
import com.julianraj.mvpstartkit.domain.executor.PostExecutionThread;
import com.julianraj.mvpstartkit.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity pBaseActivity);

    Context getContext();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();
}
