package com.vjam.demo.ui.main;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.vjam.demo.R;
import com.vjam.demo.ui.base.BaseActivity;
import com.vjam.demo.ui.cart.CartFragment;
import com.vjam.demo.ui.fav.FavFragment;
import com.vjam.demo.ui.home.HomeFragment;
import com.vjam.demo.ui.setting.SettingsFragment;
import com.vjam.demo.ui.whatshot.WhatsHotFragment;

public class MainActivity extends BaseActivity {

    private BottomNavigationView navigation;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);

        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //BottomNavigationViewHelper.disableShiftMode(navigation);
        HomeFragment homeFragment = new HomeFragment();
        openFragment(homeFragment);


        navigation.setItemBackgroundResource(R.color.black);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(R.color.black)));

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.action_home:


                        HomeFragment homeFragment = new HomeFragment();
                        openFragment(homeFragment);

                        navigation.setItemBackgroundResource(R.color.black);
                        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources().getColor(R.color.black)));
                        break;

                    case R.id.action_favorites:
                        openFragment(FavFragment.newInstance());
                        navigation.setItemBackgroundResource(R.color.colorAccent);
                        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources().getColor(R.color.colorAccent)));
                        break;
                    case R.id.action_schedules:


                        WhatsHotFragment fragment = new WhatsHotFragment();
                        openFragment(fragment);

                        navigation.setItemBackgroundResource(R.color.yellow);
                        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources().getColor(R.color.yellow)));
                        break;

                    case R.id.action_music:
                        openFragment(CartFragment.newInstance());
                        navigation.setItemBackgroundResource(R.color.green);
                        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources().getColor(R.color.green)));
                        break;

                    case R.id.action_setting:
                        openFragment(SettingsFragment.newInstance());
                        navigation.setItemBackgroundResource(R.color.colorPrimaryDark);
                        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
                        break;
                }

                return false;

            }
        });

    }

    @Override
    protected void setUp() {

    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
