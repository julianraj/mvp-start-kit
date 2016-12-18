package com.julianraj.mvpstartkit.di.component;

import com.julianraj.mvpstartkit.data.api.ApiManager;
import com.julianraj.mvpstartkit.di.PerActivity;
import com.julianraj.mvpstartkit.di.module.NetworkModule;

import dagger.Component;
import retrofit2.Retrofit;

@PerActivity
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    Retrofit getRetrofit();

    ApiManager getApiManager();

}
