package com.julianraj.mvpstartkit;


import android.app.Application;

import com.julianraj.mvpstartkit.di.component.ApplicationComponent;
import com.julianraj.mvpstartkit.di.component.DaggerApplicationComponent;
import com.julianraj.mvpstartkit.di.module.ApplicationModule;

public class MyApplication extends Application {
    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
