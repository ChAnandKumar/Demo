package com.vjam.demo.di.component;

import com.vjam.demo.di.PerActivity;
import com.vjam.demo.di.module.ActivityModule;

import dagger.Subcomponent;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    /*void inject(SplashActivity activity);

    void inject(Home home);

    void inject(AddDataActivity addDataActivity);*/
    //@ConfigPersistent CompositeDisposable getCompositeDisposable();


}
