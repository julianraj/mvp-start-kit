package com.julianraj.mvpstartkit.di.module;

import com.julianraj.mvpstartkit.BuildConfig;
import com.julianraj.mvpstartkit.data.api.ApiManager;
import com.julianraj.mvpstartkit.data.api.ApiService;
import com.julianraj.mvpstartkit.data.api.HeaderInterceptor;
import com.julianraj.mvpstartkit.di.PerActivity;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    OkHttpClient provideHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
                .addInterceptor(new HeaderInterceptor())
                .build();
    }

    @Provides
    @PerActivity
    Retrofit provideRetrofit(OkHttpClient pOkHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(pOkHttpClient)
                .build();
    }

    @Provides
    @PerActivity
    ApiManager provideApiManager(Retrofit retrofit) {
        return new ApiManager(retrofit.create(ApiService.class));
    }
}