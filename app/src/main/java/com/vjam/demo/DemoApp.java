package com.vjam.demo;

import android.app.Application;

import com.amitshekhar.DebugDB;
import com.vjam.demo.data.DataManager;
import com.vjam.demo.di.component.ApplicationComponent;
import com.vjam.demo.di.component.BusComponent;
import com.vjam.demo.di.component.DaggerApplicationComponent;
import com.vjam.demo.di.component.DaggerBusComponent;
import com.vjam.demo.di.module.ApplicationModule;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by anand.chandaliya on 16-03-2017.
 */

public class DemoApp extends Application {

    @Inject
    DataManager dataManager;

    private static BusComponent sBusComponent;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        sBusComponent = DaggerBusComponent.create();

        applicationComponent.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            DebugDB.getAddressLog();
        }
    }

    public static BusComponent getBusComponent() {
        return sBusComponent;
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }



    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
