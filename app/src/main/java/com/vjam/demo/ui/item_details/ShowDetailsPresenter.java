package com.vjam.demo.ui.item_details;

import com.vjam.demo.data.DataManager;
import com.vjam.demo.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anand.chandaliya on 05-04-2017.
 */

public class ShowDetailsPresenter<V extends ShowDetailsMvpView> extends BasePresenter<V> implements ShowDetailsMvpPresenter<V> {

    @Inject
    public ShowDetailsPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getMvpView().displayData(null);
    }


}
