package com.julianraj.mvpstartkit.ui.view;

import android.content.Context;

public interface MvpView {
    void showErrorView(String pErrorMessage);

    Context getContext();
}
