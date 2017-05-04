package com.vjam.demo.ui.item_details;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.vjam.demo.R;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowDetailsActivity extends BaseActivity implements ShowDetailsMvpView{

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.item_main_image)
    ImageView itemMainImage;
    @BindView(R.id.item_thumbs_iv)
    RecyclerView itemThumbsIv;
    @BindView(R.id.item_title_txt)
    TextView itemTitleTxt;
    @BindView(R.id.item_price_txt)
    TextView itemPriceTxt;
    @BindView(R.id.item_delivery_charges_txt)
    TextView itemDeliveryChargesTxt;
    @BindView(R.id.item_rateing_txt)
    TextView itemRateingTxt;
    @BindView(R.id.iv_btn)
    ImageView ivBtn;
    @BindView(R.id.fav_iv_btn)
    ImageView favIvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        int pos = getIntent().getExtras().getInt("pos");
        toolbar.setTitle("Details of Postion : " + pos);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            //getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    protected void setUp() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayData(Item item) {

    }
}
