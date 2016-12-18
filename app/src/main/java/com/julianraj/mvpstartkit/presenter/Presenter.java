package com.julianraj.mvpstartkit.presenter;

import com.julianraj.mvpstartkit.ui.view.MvpView;

public interface Presenter<V extends MvpView> {
    void attachView(V view);
}
