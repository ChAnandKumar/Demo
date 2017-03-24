package com.vjam.demo.di.module;

import android.app.Activity;
import android.content.Context;

import com.vjam.demo.di.ActivityContext;
import com.vjam.demo.di.PerActivity;
import com.vjam.demo.ui.home.HomeMvpPresenter;
import com.vjam.demo.ui.home.HomeMvpView;
import com.vjam.demo.ui.home.HomePresenter;
import com.vjam.demo.ui.splash.SplashMvpPresenter;
import com.vjam.demo.ui.splash.SplashMvpView;
import com.vjam.demo.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }


    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView>
                                                                     presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeMvpView> provideHomePresenter(HomePresenter<HomeMvpView>
                                                                     presenter) {
        return presenter;
    }
}
