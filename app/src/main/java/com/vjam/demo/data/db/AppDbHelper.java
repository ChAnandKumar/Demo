package com.vjam.demo.data.db;


import com.vjam.demo.data.db.item_model.DaoMaster;
import com.vjam.demo.data.db.item_model.DaoSession;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.data.db.item_model.ItemDao;
import com.vjam.demo.data.db.item_model.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */

public class AppDbHelper implements DbHelper {

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
                return !(mDaoSession.getUserDao().count() > 0);
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
                return !(mDaoSession.getItemDao().count() > 0);
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
                //mDaoSession.getItemDao().dropTable(mDaoSession.getDatabase(), true);
                //mDaoSession.getItemDao().createTable(mDaoSession.getDatabase(), true);
                //mDaoSession.getItemDao().saveInTx(items);
                mDaoSession.getItemDao().insertOrReplaceInTx(items);
                return true;
            }
        });
    }


    /**
     * String updateQuery = "update "+PersonDao.TABLENAME
     + " set "+PersonDao.Properties.Name.columnName + "=?"
     +" where " + PersonDao.Properties.Id.columnName + "=?";

     mDaoMaster.getDatabase().execSQL(updateQuery, new Object[] {"VISHAL", 10});

     Donnot forget to refresh your entity: personDao.refresh(person10)*/
    @Override
    public Observable<Boolean> updateItemData(final Item item,final int position) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                String updateQuery = "update "+ ItemDao.TABLENAME
                        + " set "+ItemDao.Properties.IsItemFav.columnName + "=?"
                        +" where " + ItemDao.Properties.ItemId.columnName + "=?";
                mDaoSession.getDatabase().execSQL(updateQuery, new Object[] {true, "1001" });
                mDaoSession.refresh(item);
                //mDaoSession.getItemDao().update(item);
                return true;
            }
        });
    }

}



