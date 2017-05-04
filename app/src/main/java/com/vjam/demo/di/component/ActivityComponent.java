package com.vjam.demo.di.component;

import com.vjam.demo.di.PerActivity;
import com.vjam.demo.di.module.ActivityModule;
import com.vjam.demo.ui.cart.CartFragment;
import com.vjam.demo.ui.fav.FavFragment;
import com.vjam.demo.ui.home.HomeFragment;
import com.vjam.demo.ui.item_details.ShowDetailsActivity;
import com.vjam.demo.ui.main.MainActivity;
import com.vjam.demo.ui.splash.SplashScreenActivity;
import com.vjam.demo.ui.whatshot.WhatsHotFragment;

import dagger.Component;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashScreenActivity activity);

    void inject(MainActivity activity);

    void inject(HomeFragment homeFragment);

    void inject(FavFragment favFragment);

    void inject(CartFragment cartFragment);

    void inject(WhatsHotFragment whatsHotFragment);

    void inject(ShowDetailsActivity showDetailsActivity);
    /*

    void inject(Home home);

    void inject(AddDataActivity addDataActivity);*/
    //@ConfigPersistent CompositeDisposable getCompositeDisposable();


}
