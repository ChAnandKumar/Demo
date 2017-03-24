package com.vjam.demo.ui.home;

/**
 * Created by anand.chandaliya on 24-03-2017.
 */

public interface HomeAdapterCallback {

    void onFavClicked(int postion);
    void onAddToCartClicked(int postion);

    void onItemClicked(int position);
}
