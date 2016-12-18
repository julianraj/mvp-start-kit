package com.julianraj.mvpstartkit.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.julianraj.mvpstartkit.MyApplication;
import com.julianraj.mvpstartkit.R;
import com.julianraj.mvpstartkit.di.component.ApplicationComponent;
import com.julianraj.mvpstartkit.di.module.ActivityModule;
import com.julianraj.mvpstartkit.ui.view.MvpView;
import com.julianraj.mvpstartkit.util.PreferenceHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    public ViewDataBinding mBinding;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @Inject
    PreferenceHelper mPreferenceHelper;

    public abstract int getLayout();

    public boolean isDataBindingEnabled() {
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        if (!isDataBindingEnabled()) {
            setContentView(getLayout());
            ButterKnife.bind(this);
        } else {
            mBinding = DataBindingUtil.setContentView(this, getLayout());
            ButterKnife.bind(this, mBinding.getRoot());
        }
        initializeToolbar();
    }

    @Override
    public void showErrorView(String pErrorMessage) {
        Snackbar.make(getWindow().getDecorView(), pErrorMessage, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void initializeToolbar() {
        //mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar == null) {
            throw new IllegalStateException("Layout is required to include a Toolbar with id " +
                    "'toolbar'");
        }
        setUpToolbarMenu();
        setSupportActionBar(mToolbar);
    }

    public void setUpToolbarMenu() {
        //mToolbar.inflateMenu(R.menu.main);
    }

    protected Toolbar getToolbar() {
        return mToolbar;
    }

    public PreferenceHelper getPreferenceHelper() {
        return mPreferenceHelper;
    }

    public ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
