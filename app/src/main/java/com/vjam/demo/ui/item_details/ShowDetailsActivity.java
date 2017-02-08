package com.vjam.demo.ui.item_details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.vjam.demo.R;

public class ShowDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        int pos = getIntent().getExtras().getInt("pos");
        toolbar.setTitle("Details of Postion : "+pos);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            //getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
