package com.vjam.demo.ui.home;

import com.vjam.demo.data.DataManager;
import com.vjam.demo.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

/**
 * Created by anand.chandaliya on 24-03-2017.
 */

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {

    @Inject
    public HomePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }



    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        Timber.i("in HomePresenter onAttach");

    }

    @Override
    public void addToFav(int postion) {
        Timber.i("in HomePresenter Fav"+postion);
    }

    @Override
    public void addToCart(int postion) {
        Timber.i("in HomePresenter Cart"+postion);

    }
}
