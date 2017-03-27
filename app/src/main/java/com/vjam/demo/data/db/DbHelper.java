package com.vjam.demo.data.db;


import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.data.db.item_model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */

public interface DbHelper {

    /** User */
    Observable<Boolean> insertUser(User user);

    Observable<Boolean> isUserEmpty();

    Observable<User> getUserData();



    /** Item */
    Observable<List<Item>> getAllItems();

    Observable<Boolean> insertItem(Item item);

    Observable<Boolean> isItemEmpty();

    Observable<Item> getItemData();

    Observable<Boolean> saveItemList(List<Item> items);






    /*Observable<List<RModel>> getAllReportData();

    Observable<Long> insertReport(RModel report);

    Observable<Long> insertProfile(PModel profile);

    Observable<List<PModel>> getProfileData();

    Observable<Boolean> isProfileEmpty();*/

    //Observable<Boolean> isReportEmpty();

    //Observable<Boolean> saveProfile(PModel profile);

    //Observable<Boolean> saveReport(RModel report);

    //Observable<Boolean> saveProfileList(List<PModel> profileList);

    //Observable<Boolean> saveReportList(List<RModel> reportList);

}
