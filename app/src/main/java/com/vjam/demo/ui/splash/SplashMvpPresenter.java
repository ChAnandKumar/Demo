package com.vjam.demo.ui.splash;

import com.vjam.demo.di.PerActivity;
import com.vjam.demo.ui.base.MvpPresenter;

/**
 * Created by anand.chandaliya on 22-03-2017.
 */

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
}
