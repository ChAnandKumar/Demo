package com.vjam.demo.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.vjam.demo.R;
import com.vjam.demo.ui.base.BaseActivity;
import com.vjam.demo.ui.login.LoginActivity;
import com.vjam.demo.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import timber.log.Timber;

public class SplashScreenActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        Timber.i("Before Attach");
        mPresenter.onAttach(SplashScreenActivity.this);

       /* Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();*/
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openSingInScreen() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void openHomeScreen() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void openSyncService() {

    }
}
