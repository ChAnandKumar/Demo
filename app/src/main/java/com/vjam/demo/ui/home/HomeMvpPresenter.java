package com.vjam.demo.ui.home;

import com.vjam.demo.di.PerActivity;
import com.vjam.demo.ui.base.MvpPresenter;

/**
 * Created by anand.chandaliya on 24-03-2017.
 */

@PerActivity
public interface HomeMvpPresenter<V extends HomeMvpView> extends MvpPresenter<V> {
    void addToFav(int postion);

    void addToCart(int postion);
}
