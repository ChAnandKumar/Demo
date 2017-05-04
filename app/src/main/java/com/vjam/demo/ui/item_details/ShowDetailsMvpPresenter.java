package com.vjam.demo.ui.item_details;

import com.vjam.demo.di.PerActivity;
import com.vjam.demo.ui.base.MvpPresenter;

/**
 * Created by anand.chandaliya on 05-04-2017.
 */

@PerActivity
public interface ShowDetailsMvpPresenter<V extends ShowDetailsMvpView> extends MvpPresenter<V> {
}
