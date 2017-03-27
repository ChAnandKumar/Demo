package com.vjam.demo.data.db;


import com.vjam.demo.data.db.item_model.DaoMaster;
import com.vjam.demo.data.db.item_model.DaoSession;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.data.db.item_model.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */

public class AppDbHelper implements DbHelper{

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Boolean> insertUser(final User user) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getUserDao().saveInTx(user);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> isUserEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getUserDao().count()>0);
            }
        });
    }

    @Override
    public Observable<User> getUserData() {
        return Observable.fromCallable(new Callable<User>() {
            @Override
            public User call() throws Exception {
                return (User) mDaoSession.getUserDao().loadAll();
            }
        });
    }

    @Override
    public Observable<List<Item>> getAllItems() {
        return Observable.fromCallable(new Callable<List<Item>>() {
            @Override
            public List<Item> call() throws Exception {
                return mDaoSession.getItemDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> insertItem(final Item item) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getItemDao().saveInTx(item);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> isItemEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return  !(mDaoSession.getItemDao().count()>0);
            }
        });
    }

    @Override
    public Observable<Item> getItemData() {
        return Observable.fromCallable(new Callable<Item>() {
            @Override
            public Item call() throws Exception {
                return (Item) mDaoSession.getItemDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> saveItemList(final List<Item> items) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getItemDao().saveInTx(items);
                return true;
            }
        });
    }


    /*@Override
    public Observable<List<RModel>> getAllReportData() {
        return Observable.fromCallable(new Callable<List<RModel>>() {
            @Override
            public List<RModel> call() throws Exception {
                return mDaoSession.getRModelDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Long> insertReport(final RModel report) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getRModelDao().insert(report);
            }
        });
    }

    @Override
    public Observable<Long> insertProfile(final PModel profile) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getPModelDao().insert(profile);
            }
        });
    }

    @Override
    public Observable<List<PModel>> getProfileData() {
        return Observable.fromCallable(new Callable<List<PModel>>() {
            @Override
            public List<PModel> call() throws Exception {
                return mDaoSession.getPModelDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> isProfileEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getPModelDao().count()>0);
            }
        });
    }

    @Override
    public Observable<Boolean> isReportEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getRModelDao().count() > 0);
            }
        });
    }

    @Override
    public Observable<Boolean> saveProfile(final PModel profile) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getPModelDao().saveInTx(profile);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveReport(final RModel report) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getRModelDao().saveInTx(report);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveProfileList(final List<PModel> profileList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getPModelDao().saveInTx(profileList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveReportList(final List<RModel> reportList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getRModelDao().saveInTx(reportList);
                return true;
            }
        });
    }*/
}
