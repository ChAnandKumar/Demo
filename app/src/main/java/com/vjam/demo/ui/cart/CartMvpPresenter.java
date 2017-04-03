package com.vjam.demo.ui.cart;

import com.vjam.demo.di.PerActivity;
import com.vjam.demo.ui.base.MvpPresenter;

/**
 * Created by anand.chandaliya on 03-04-2017.
 */

@PerActivity
public interface CartMvpPresenter<V extends CartMvpView> extends MvpPresenter<V> {
}
