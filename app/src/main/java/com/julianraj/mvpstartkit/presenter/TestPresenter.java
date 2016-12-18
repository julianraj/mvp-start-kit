package com.julianraj.mvpstartkit.presenter;

import android.os.Bundle;

import com.julianraj.mvpstartkit.domain.interactor.Interactor;
import com.julianraj.mvpstartkit.models.TestModel;
import com.julianraj.mvpstartkit.ui.view.TestView;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by julian on 12/17/16.
 */

public class TestPresenter implements Presenter<TestView> {

    private TestView mView;
    private Interactor mInteractor;
    private Bundle params;

    @Inject
    public TestPresenter(@Named("test") Interactor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void attachView(TestView view) {
        mView = view;
    }

    public void fetchModel() {
        mView.showLoadingView();
        mInteractor.execute(new MyTestSubscriber());
    }

    private final class MyTestSubscriber extends Subscriber<TestModel> {
        @Override
        public void onCompleted() {
            mView.hideLoadingView();
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoadingView();
            mView.showErrorView(e.getMessage());
        }

        @Override
        public void onNext(TestModel testModel) {
            mView.renderTestModel(testModel);
        }
    }
}
