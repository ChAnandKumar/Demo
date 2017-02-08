package com.vjam.demo;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.vjam.demo.ui.home.HomeFragment;
import com.vjam.demo.ui.whatshot.WhatsHotFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //BottomNavigationViewHelper.disableShiftMode(navigation);




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
                        navigation.setItemBackgroundResource(R.color.green);
                        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources().getColor(R.color.green)));
                        break;

                    case R.id.action_setting:
                        navigation.setItemBackgroundResource(R.color.colorPrimaryDark);
                        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
                        break;
                }

                return false;

            }
        });

    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "HOME");
        fragmentTransaction.commit();
    }
}
