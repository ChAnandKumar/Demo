package com.vjam.demo.data;


import com.vjam.demo.data.db.DbHelper;
import com.vjam.demo.data.prefs.PreferencesHelper;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

public interface DataManager extends DbHelper,PreferencesHelper {

    Observable<Boolean> loadUserData();
    Observable<Boolean> loadItems();

    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
