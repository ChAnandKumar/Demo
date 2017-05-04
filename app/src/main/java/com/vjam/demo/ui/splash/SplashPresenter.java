package com.vjam.demo.ui.splash;

import com.vjam.demo.data.DataManager;
import com.vjam.demo.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by anand.chandaliya on 22-03-2017.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V>{


    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        Timber.d("onAttach is called."  +getDataManager());

        getCompositeDisposable().add(getDataManager()
                .syncItemData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .concatMap(aBoolean -> {
                    Timber.d("concatMap is called in SplashPresenter.");
                    return getDataManager().loadItems();
                })
                .subscribe(aBoolean -> {
                    Timber.d("subscribe is called in SplashPresenter.");
                    if (!isViewAttached()) {
                        return;
                    }
                    decideNextActivity();
                }, throwable -> {
                    throwable.printStackTrace();
                    Timber.d("Throwable is called in SplashPresenter.");
                    if(!isViewAttached()) {
                        return;
                    }
                    //getMvpView().onError("Some Error");
                    decideNextActivity();
                }));


        //getMvpView().openHomeScreen();
        /*getCompositeDisposable().add(getDataManager()
                .loadItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .concatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Boolean aBoolean) throws Exception {
                        return getDataManager().loadItems();
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        decideNextActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(!isViewAttached()) {
                            return;
                        }
                        getMvpView().onError("Some Error");
                        decideNextActivity();
                    }
                }));*/
    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode()
                == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getMvpView().openSingInScreen();
        } else {
            getMvpView().openHomeScreen();
        }
    }
}
