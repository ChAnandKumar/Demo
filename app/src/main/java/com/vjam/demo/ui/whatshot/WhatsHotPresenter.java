package com.vjam.demo.ui.whatshot;

import com.vjam.demo.data.DataManager;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by anand.chandaliya on 03-04-2017.
 */

public class WhatsHotPresenter<V extends WhatsHotMvpView> extends BasePresenter<V> implements WhatsHotMvpPresenter<V> {

    @Inject
    public WhatsHotPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        Timber.i("Whats Hot Presenter....");

        getMvpView().showLoading();
        Timber.i("onAttach : FavPresenter");
        getCompositeDisposable().add(getDataManager().getAllItems()
                .flatMapIterable(new Function<List<Item>, Iterable<Item>>() {
                    @Override
                    public Iterable<Item> apply(List<Item> items) throws Exception {
                        return items;
                    }
                }).filter(new Predicate<Item>() {
                    @Override
                    public boolean test(Item item) throws Exception {
                        if(item.getIsItemTrending() != null)
                            return Boolean.parseBoolean(item.getIsItemTrending());
                        return false;
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Item>>() {
                    @Override
                    public void accept(List<Item> items) throws Exception {
                        Timber.i("onAttach : FavPresenter ::: " + items.size());
                        getMvpView().hideLoading();
                        getMvpView().loadWhatsHotItems(items);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().hideLoading();
                    }
                }));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
