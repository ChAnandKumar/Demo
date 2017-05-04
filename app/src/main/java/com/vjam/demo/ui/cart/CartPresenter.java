package com.vjam.demo.ui.cart;

import com.vjam.demo.data.DataManager;
import com.vjam.demo.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by anand.chandaliya on 03-04-2017.
 */

public class CartPresenter<V extends CartMvpView> extends BasePresenter<V> implements CartMvpPresenter<V> {
    @Inject
    public CartPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getMvpView().showLoading();
        Timber.i("onAttach : CartPresenter");
        getCompositeDisposable().add(getDataManager().getAllItems()
                .flatMapIterable(items -> items).filter(item -> {
                    //if(item.getIsItemAddedToCart() != null)
                        return item.isItemAddedToCart();
                    //return false;
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                    Timber.i("onAttach : CartPresenter ::: " + items.size());
                    getMvpView().hideLoading();
                    if (items.size() == 0)
                        getMvpView().showCartEmptyMessage("Your Cart is Empty");
                    else
                        getMvpView().loadCartList(items);
                }, throwable -> {
                    getMvpView().hideLoading();
                    getMvpView().showCartEmptyMessage("Your Cart is Empty");
                }));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
