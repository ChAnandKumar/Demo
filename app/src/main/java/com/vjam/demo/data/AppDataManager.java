package com.vjam.demo.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vjam.demo.data.db.DbHelper;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.data.db.item_model.User;
import com.vjam.demo.data.network.ItemServices;
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
    private ItemServices mItemServices;
    private DataManager dataManager;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper,
                          PreferencesHelper preferencesHelper, ItemServices mItemServices) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.preferencesHelper = preferencesHelper;
        this.mItemServices = mItemServices;
    }

   /* @Override
    public Observable<Item> syncItemData() {
        return mItemServices.getItems()
                .concatMap(new Function<List<Item>, ObservableSource<? extends Item>>() {
                    @Override
                    public ObservableSource<? extends Item> apply(List<Item> items) throws Exception {
                        return dbHelper.saveItemList(items);
                    }
                });
    }*/

    @Override
    public Observable<Boolean> syncItemData() {
        return mItemServices.getItems()
                .concatMap(new Function<List<Item>, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(List<Item> items) throws Exception {
                        return dbHelper.saveItemList(items);
                    }
                });
    }

    @Override
    public Observable<Boolean> loadUserData() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return dbHelper.isUserEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                               @Override
                               public ObservableSource<? extends Boolean> apply(Boolean isEmpty) throws Exception {
                                   if (isEmpty) {
                                       Type type = new TypeToken<User>() {
                                       }
                                               .getType();
                                       User optionList = gson.fromJson(
                                                       CommonUtils.loadJSONFromAsset(context,
                                                       AppConstants.SEED_DATABASE_REPORT),
                                               type);

                                      /*User optionList = mItemServices.getItems();*/

                                       return insertUser(optionList);
                                   }
                                   return Observable.just(false);
                               }
                           });

        //return dataManager.loadUserData();
    }

    @Override
    public Observable<Boolean> loadItems() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        return dbHelper.isItemEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = new TypeToken<List<Item>>() {
                            }
                                    .getType();
                            List<Item> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(context,
                                            AppConstants.SEED_DATABASE_REPORT),
                                    type);

                            //List<Item> optionList = mItemServices.getItems();

                            //return saveItemList(optionList);
                            return  null;//temp
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode,
                               String userName, String email, String profilePicPath) {


            setAccessToken(accessToken);
            setCurrentUserId(userId);
            setCurrentUserLoggedInMode(loggedInMode);
            setCurrentUserName(userName);
            setCurrentUserEmail(email);
            setCurrentUserProfilePicUrl(profilePicPath);

            //updateApiHeader(userId, accessToken);
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

    @Override
    public Observable<Boolean> insertUser(User user) {
        return dbHelper.insertUser(user);
    }

    @Override
    public Observable<Boolean> isUserEmpty() {
        return dbHelper.isUserEmpty();
    }

    @Override
    public Observable<User> getUserData() {
        return dbHelper.getUserData();
    }

    @Override
    public Observable<List<Item>> getAllItems() {
        return dbHelper.getAllItems();
    }

    @Override
    public Observable<Boolean> insertItem(Item item) {
        return dbHelper.insertItem(item);
    }

    @Override
    public Observable<Boolean> isItemEmpty() {
        return dbHelper.isItemEmpty();
    }

    @Override
    public Observable<Item> getItemData() {
        return dbHelper.getItemData();
    }

    @Override
    public Observable<Boolean> saveItemList(List<Item> items) {
        return dbHelper.saveItemList(items);
    }

    @Override
    public Observable<Boolean> updateFav(String itemId,boolean isFav) {
        return dbHelper.updateFav(itemId,isFav);
    }

    @Override
    public Observable<Boolean> updateCartItem(String itemId, boolean isInCart) {
        return dbHelper.updateCartItem(itemId,isInCart);
    }



    /*@Override
    public Observable<Boolean> saveItemListItem(List<Item> items) {
        return dataManager.saveItemList(items);
    }*/

    /*@Override
    public Observable<Item> saveItemList(List<Item> items) {
        return dataManager.saveItemList(items);
    }*/


}
