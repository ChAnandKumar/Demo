package com.vjam.demo.di.component;

import com.vjam.demo.di.PerActivity;
import com.vjam.demo.di.module.ActivityModule;
import com.vjam.demo.ui.home.HomeFragment;
import com.vjam.demo.ui.main.MainActivity;
import com.vjam.demo.ui.splash.SplashScreenActivity;

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
    /*

    void inject(Home home);

    void inject(AddDataActivity addDataActivity);*/
    //@ConfigPersistent CompositeDisposable getCompositeDisposable();


}
