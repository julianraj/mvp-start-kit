package com.julianraj.mvpstartkit.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.julianraj.mvpstartkit.R;
import com.julianraj.mvpstartkit.base.BaseActivity;
import com.julianraj.mvpstartkit.di.component.DaggerDataComponent;
import com.julianraj.mvpstartkit.di.module.DataModule;
import com.julianraj.mvpstartkit.models.TestModel;
import com.julianraj.mvpstartkit.presenter.TestPresenter;
import com.julianraj.mvpstartkit.ui.view.TestView;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements TestView {

    private static final String TAG = "MainActivity";
    @Inject
    TestPresenter mPresenter;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.fetchModel();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initializePresenter();
    }

    private void initializePresenter() {
        DaggerDataComponent.builder()
                .dataModule(new DataModule(1l))
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
        mPresenter.attachView(this);
        mPresenter.fetchModel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void renderTestModel(TestModel testModel) {
        Log.d(TAG, testModel.getId() + ": " + testModel.getTitle());
    }

    @Override
    public void showLoadingView() {
        Log.d(TAG, "started request");
    }

    @Override
    public void hideLoadingView() {
        Log.d(TAG, "request ended");
    }
}
