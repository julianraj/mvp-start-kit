package com.julianraj.mvpstartkit.data.api;

import com.julianraj.mvpstartkit.models.TestModel;

import javax.inject.Inject;

import rx.Observable;

public class ApiManager {
    ApiService mApiService;

    @Inject
    public ApiManager(ApiService pApiService) {
        mApiService = pApiService;
    }

    public Observable<TestModel> getTestModel(Long testId) {
        return mApiService.getTestModel(testId);
    }
}
