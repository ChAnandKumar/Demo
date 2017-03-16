package com.vjam.demo.data;


import com.vjam.demo.data.db.DbHelper;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 02-03-2017.
 */

public interface DataManager extends DbHelper {

    Observable<Boolean> loadProfileData();
    Observable<Boolean> loadReport();
}
