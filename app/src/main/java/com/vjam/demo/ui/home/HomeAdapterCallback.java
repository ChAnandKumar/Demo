package com.vjam.demo.ui.home;

/**
 * Created by anand.chandaliya on 24-03-2017.
 */

public interface HomeAdapterCallback {

    void onFavClicked(String itemId, boolean isFavAdded);
    void onAddToCartClicked(String itemId, boolean isCartAdded);

    void onItemClicked(int position);
}
