package com.vjam.demo.di.module;

import android.app.Activity;
import android.content.Context;

import com.vjam.demo.di.ActivityContext;
import com.vjam.demo.di.PerActivity;
import com.vjam.demo.ui.cart.CartMvpPresenter;
import com.vjam.demo.ui.cart.CartMvpView;
import com.vjam.demo.ui.cart.CartPresenter;
import com.vjam.demo.ui.fav.FavMvpPresenter;
import com.vjam.demo.ui.fav.FavMvpView;
import com.vjam.demo.ui.fav.FavPresenter;
import com.vjam.demo.ui.home.HomeMvpPresenter;
import com.vjam.demo.ui.home.HomeMvpView;
import com.vjam.demo.ui.home.HomePresenter;
import com.vjam.demo.ui.item_details.ShowDetailsMvpPresenter;
import com.vjam.demo.ui.item_details.ShowDetailsMvpView;
import com.vjam.demo.ui.item_details.ShowDetailsPresenter;
import com.vjam.demo.ui.splash.SplashMvpPresenter;
import com.vjam.demo.ui.splash.SplashMvpView;
import com.vjam.demo.ui.splash.SplashPresenter;
import com.vjam.demo.ui.whatshot.WhatsHotMvpPresenter;
import com.vjam.demo.ui.whatshot.WhatsHotMvpView;
import com.vjam.demo.ui.whatshot.WhatsHotPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }


    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView>
                                                                     presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeMvpView> provideHomePresenter(HomePresenter<HomeMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    FavMvpPresenter<FavMvpView> provideFavPresenter(FavPresenter<FavMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    CartMvpPresenter<CartMvpView> provideCartPresenter(CartPresenter<CartMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    WhatsHotMvpPresenter<WhatsHotMvpView> provideWhatsHotPresenter(WhatsHotPresenter<WhatsHotMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ShowDetailsMvpPresenter<ShowDetailsMvpView> provideShowDetailsPresenter(ShowDetailsPresenter<ShowDetailsMvpView> presenter) {
        return presenter;
    }
}
