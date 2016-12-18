package com.julianraj.mvpstartkit.di.module;


import android.app.Activity;

import com.julianraj.mvpstartkit.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity pActivity) {
        this.mActivity = pActivity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }
}


