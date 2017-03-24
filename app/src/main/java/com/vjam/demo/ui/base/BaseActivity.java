package com.vjam.demo.ui.base;/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */


import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.vjam.demo.DemoApp;
import com.vjam.demo.R;
import com.vjam.demo.di.component.ActivityComponent;
import com.vjam.demo.di.component.DaggerActivityComponent;
import com.vjam.demo.di.module.ActivityModule;
import com.vjam.demo.util.CommonUtils;
import com.vjam.demo.util.NetworkUtils;

import butterknife.Unbinder;
import timber.log.Timber;


/**
 * Created by janisharali on 27/01/17.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView, BaseFragment.Callback {

    private ProgressDialog mProgressDialog;

    private ActivityComponent mActivityComponent;

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.e("onCreate of BaseActivity");
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((DemoApp) getApplication()).getApplicationComponent())
                .build();

    }

    public ActivityComponent getActivityComponent() {
        Timber.e("getActivityComponent of BaseActivity");

        return mActivityComponent;
    }

   /* @Override
    protected void attachBaseContext(Context newBase) {
        Timber.e("attachBaseContext of BaseActivity");
       // super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        Timber.e("requestPermissionsSafely of BaseActivity");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        Timber.e("hasPermission of BaseActivity");
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void showLoading() {
        Timber.e("showLoading of BaseActivity");
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        Timber.e("hideLoading of BaseActivity");
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {
        Timber.e("onError of BaseActivity");
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar("Some Error");
        }
    }

    private void showSnackBar(String message) {
        Timber.e("showSnackBar of BaseActivity");
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    public void onError(@StringRes int resId) {
        Timber.e("onError resId of BaseActivity");
        onError(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        Timber.e("isNetworkConnected of BaseActivity");
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {
        Timber.e("onFragmentAttached of BaseActivity");
    }

    @Override
    public void onFragmentDetached(String tag) {
        Timber.e("onFragmentDetached of BaseActivity");
    }

    public void hideKeyboard() {
        Timber.e("hideKeyboard of BaseActivity");
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        Timber.e("openActivityOnTokenExpire of BaseActivity");
        /*startActivity(LoginActivity.getStartIntent(this));
        finish();*/
    }

    public void setUnBinder(Unbinder unBinder) {
        Timber.e("setUnBinder of BaseActivity");
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        Timber.e("onDestroy of BaseActivity");

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();
}
