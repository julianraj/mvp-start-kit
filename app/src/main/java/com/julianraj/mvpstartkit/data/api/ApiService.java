package com.julianraj.mvpstartkit.data.api;


import com.julianraj.mvpstartkit.models.TestModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiService {
    public static final String API_TEST = "posts/{id}";

    @GET(API_TEST)
    Observable<TestModel> getTestModel(@Path("id") Long testId);
}
