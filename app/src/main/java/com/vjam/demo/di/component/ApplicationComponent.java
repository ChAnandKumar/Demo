package com.vjam.demo.di.component;

import android.app.Application;
import android.content.Context;

import com.vjam.demo.DemoApp;
import com.vjam.demo.data.DataManager;
import com.vjam.demo.di.ApplicationContext;
import com.vjam.demo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApp demoApp);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}

