package com.julianraj.mvpstartkit.di.component;

import android.app.Activity;

import com.julianraj.mvpstartkit.di.PerActivity;
import com.julianraj.mvpstartkit.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = ActivityModule.class
)
public interface ActivityComponent {
    Activity getActivity();
}
