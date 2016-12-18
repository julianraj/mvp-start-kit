package com.julianraj.mvpstartkit.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julianraj.mvpstartkit.ui.view.MvpView;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements MvpView {

    public ViewDataBinding mBinding;

    public abstract int getLayout();

    public boolean isDataBindingEnabled() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view;
        if (!isDataBindingEnabled()) {
            view = inflater.inflate(getLayout(), container, false);
        } else {
            mBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
            view = mBinding.getRoot();
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setRetainInstance(true);
    }
}
