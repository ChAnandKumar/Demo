package com.vjam.demo.di.module;

import android.app.Application;
import android.content.Context;

import com.vjam.demo.data.AppDataManager;
import com.vjam.demo.data.DataManager;
import com.vjam.demo.data.db.AppDbHelper;
import com.vjam.demo.data.db.DbHelper;
import com.vjam.demo.data.prefs.AppPreferencesHelper;
import com.vjam.demo.data.prefs.PreferencesHelper;
import com.vjam.demo.di.ApplicationContext;
import com.vjam.demo.di.DatabaseInfo;
import com.vjam.demo.di.PreferenceInfo;
import com.vjam.demo.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }


    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
}
