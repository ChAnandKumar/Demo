package com.vjam.demo.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.vjam.demo.R;
import com.vjam.demo.model.ItemModel;
import com.vjam.demo.ui.base.BaseActivity;
import com.vjam.demo.ui.login.LoginActivity;
import com.vjam.demo.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import timber.log.Timber;

public class SplashScreenActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;
    private List<ItemModel> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        albumList = new ArrayList<>();

        Timber.i("Before Attach");
        mPresenter.onAttach(SplashScreenActivity.this);

       /* Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();*/
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openSingInScreen() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void openHomeScreen() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void openSyncService() {

    }


    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        ItemModel a = new ItemModel("True Romance", 13, covers[0]);
        albumList.add(a);

        a = new ItemModel("Xscpae", 8, covers[1]);
        albumList.add(a);

        a = new ItemModel("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new ItemModel("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new ItemModel("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new ItemModel("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new ItemModel("Loud", 11, covers[6]);
        albumList.add(a);

        a = new ItemModel("Legend", 14, covers[7]);
        albumList.add(a);

        a = new ItemModel("Hello", 11, covers[8]);
        albumList.add(a);

        a = new ItemModel("Greatest Hits", 17, covers[9]);
        albumList.add(a);

        //adapter.notifyDataSetChanged();
    }

}
