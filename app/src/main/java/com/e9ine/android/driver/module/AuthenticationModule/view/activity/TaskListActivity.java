package com.e9ine.android.driver.module.AuthenticationModule.view.activity;

/**
 * Created by Surendar D on 30,April,2019
 */

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.e9ine.android.driver.R;
import com.e9ine.android.driver.data.model.Example;
import com.e9ine.android.driver.databinding.ActivitySampleBinding;
import com.e9ine.android.driver.injection.Injector;
import com.e9ine.android.driver.module.AuthenticationModule.presenter.TaskListPresenter;
import com.e9ine.android.driver.module.AuthenticationModule.presenter.TaskListViewInteractor;
import com.e9ine.android.driver.module.base.BaseActivity;
import com.e9ine.android.driver.module.common.util.Bakery;
import com.e9ine.android.driver.module.common.util.ConnectivityUtil;
import com.e9ine.android.driver.module.common.util.PreferenceUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskListActivity extends BaseActivity implements TaskListViewInteractor {

    @Inject TaskListPresenter presenter;

    @Inject Bakery bakery;
    @Inject PreferenceUtil preference;
    @Inject ConnectivityUtil connectivityUtil;

    @BindView(R.id.btn_call_api) Button btnCallApi;

    private int SPLASH_TIME_OUT = 2000;
    private ActivitySampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sample);
        ButterKnife.bind(this);

        // call to inject dependencies
        Injector.component().inject(this);

        presenter.attachViewInteractor(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sample);

        init();
    }

    private void init() {
        if (connectivityUtil.isConnected()) {
            try {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bakery.snackLong(getContentView(), "Move to Login");
                    }
                }, SPLASH_TIME_OUT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            bakery.snackLong(getContentView(), "Check Internet Connection");
        }
    }

    @OnClick(R.id.btn_call_api)
    void onCallSampleApi() {
        presenter.callSampleApi();
    }

    @Override
    public void onSampleApiSuccess(Example response) {
        Log.d("onSampleApiSuccess --- ", " api result" + response);
        bakery.toastShort("Network Call Success!");
        binding.setExample(response);
        Intent navigateLogin = new Intent(TaskListActivity.this, LoginActivity.class);
        startActivity(navigateLogin);
    }

    @Override
    public void onNetworkCallProgress() {
    }

    @Override
    public void onNetworkCallCompleted() {
    }

    @Override
    public void onNetworkCallError(Throwable e) {
        bakery.toastShort(e.getMessage());
    }

}
