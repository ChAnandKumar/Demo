package com.vjam.demo.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vjam.demo.data.db.DbHelper;
import com.vjam.demo.data.db.model.PModel;
import com.vjam.demo.data.db.model.RModel;
import com.vjam.demo.data.prefs.PreferencesHelper;
import com.vjam.demo.di.ApplicationContext;
import com.vjam.demo.util.AppConstants;
import com.vjam.demo.util.CommonUtils;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

@Singleton
public class AppDataManager implements DataManager {

    private Context context;
    private DbHelper dbHelper;
    private PreferencesHelper preferencesHelper;
    private DataManager dataManager;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.preferencesHelper = preferencesHelper;
    }


    @Override
    public Observable<Boolean> loadProfileData() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        return dbHelper.isProfileEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty) throws Exception {

                        if(isEmpty){
                            Type type = new TypeToken<List<RModel>>() {
                            }
                                    .getType();
                            List<RModel> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(context,
                                            AppConstants.SEED_DATABASE_PROFILE),
                                    type);

                            return null;//saveReportList(optionList);
                        }

                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> loadReport() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return dbHelper.isProfileEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = new TypeToken<List<PModel>>() {
                            }
                                    .getType();
                            List<PModel> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(context,
                                            AppConstants.SEED_DATABASE_REPORT),
                                    type);

                            return null;//saveProfileList(optionList);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String userName, String email, String profilePicPath) {


            setAccessToken(accessToken);
            setCurrentUserId(userId);
            setCurrentUserLoggedInMode(loggedInMode);
            setCurrentUserName(userName);
            setCurrentUserEmail(email);
            setCurrentUserProfilePicUrl(profilePicPath);

            //updateApiHeader(userId, accessToken);
    }

    @Override
    public Observable<List<RModel>> getAllReportData() {
        return null;
    }

    @Override
    public Observable<Long> insertReport(RModel report) {
        return null;
    }

    @Override
    public Observable<Long> insertProfile(PModel profile) {
        return null;
    }

    @Override
    public Observable<List<PModel>> getProfileData() {
        return null;
    }

    @Override
    public Observable<Boolean> isProfileEmpty() {
        return null;
    }

    @Override
    public Observable<Boolean> isReportEmpty() {
        return null;
    }

    @Override
    public Observable<Boolean> saveProfile(PModel profile) {
        return null;
    }

    @Override
    public Observable<Boolean> saveReport(RModel report) {
        return null;
    }

    @Override
    public Observable<Boolean> saveProfileList(List<PModel> profileList) {
        return null;
    }

    @Override
    public Observable<Boolean> saveReportList(List<RModel> reportList) {
        return null;
    }


    /**
     * PrefHelper Interface Methods
     * @return
     */
    @Override
    public int getCurrentUserLoggedInMode() {
        return preferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        preferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return preferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        preferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return preferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        preferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return preferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        preferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return preferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        preferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getAccessToken() {
        return preferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        preferencesHelper.setAccessToken(accessToken);
    }

   /* @Override
    public Observable<List<RModel>> getAllReportData() {
        return dbHelper.getAllReportData();
    }

    @Override
    public Observable<Long> insertReport(RModel report) {
        return dbHelper.insertReport(report);
    }

    @Override
    public Observable<Long> insertProfile(PModel profile) {
        return dbHelper.insertProfile(profile);
    }

    @Override
    public Observable<List<PModel>> getProfileData() {
        return dbHelper.getProfileData();
    }

    @Override
    public Observable<Boolean> isProfileEmpty() {
        return dbHelper.isProfileEmpty();
    }

    @Override
    public Observable<Boolean> isReportEmpty() {
        return dbHelper.isReportEmpty();
    }

    @Override
    public Observable<Boolean> saveProfile(PModel profile) {
        return dbHelper.saveProfile(profile);
    }

    @Override
    public Observable<Boolean> saveReport(RModel report) {
        return dbHelper.saveReport(report);
    }

    @Override
    public Observable<Boolean> saveProfileList(List<PModel> profileList) {
        return dbHelper.saveProfileList(profileList);
    }

    @Override
    public Observable<Boolean> saveReportList(List<RModel> reportList) {
        return dbHelper.saveReportList(reportList);
    }*/
}
