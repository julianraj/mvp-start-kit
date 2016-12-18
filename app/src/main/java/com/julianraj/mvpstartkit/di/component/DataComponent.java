package com.julianraj.mvpstartkit.di.component;

import com.julianraj.mvpstartkit.di.PerActivity;
import com.julianraj.mvpstartkit.di.module.ActivityModule;
import com.julianraj.mvpstartkit.di.module.DataModule;
import com.julianraj.mvpstartkit.di.module.NetworkModule;
import com.julianraj.mvpstartkit.ui.activity.MainActivity;

import dagger.Component;

@PerActivity
@Component(
        dependencies = {ApplicationComponent.class},
        modules = {ActivityModule.class, DataModule.class, NetworkModule.class}
)
public interface DataComponent extends ActivityComponent {
    void inject(MainActivity activity);
}
