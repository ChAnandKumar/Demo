package com.vjam.demo.ui.home;

import com.vjam.demo.data.DataManager;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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

        getCompositeDisposable().add(getDataManager().getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Item>>() {
                    @Override
                    public void accept(List<Item> items) throws Exception {
                        getMvpView().loadItemsInViewF(items);
                    }
                }));

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void addToFav(String itemId, boolean isFav) {
        Timber.i("in HomePresenter Fav"+itemId);
        getCompositeDisposable().add(getDataManager().updateFav(itemId,isFav)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Timber.i("in HomePresenter addToFav "+aBoolean);
                    }
                }));
        //getDataManager().updateItemData(null,1);
    }

    @Override
    public void addToCart(String itemId, boolean isFav) {
        Timber.i("in HomePresenter Cart"+itemId);
        getCompositeDisposable().add(getDataManager().updateCartItem(itemId,isFav)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Timber.i("in HomePresenter Cart "+aBoolean);
                    }
                }));

    }
}
