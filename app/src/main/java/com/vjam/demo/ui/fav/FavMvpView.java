package com.vjam.demo.ui.fav;

import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.MvpView;

import java.util.List;

/**
 * Created by anand.chandaliya on 03-04-2017.
 */

public interface FavMvpView extends MvpView {
    void loadFavItemsInRv(List<Item> items);
    void showNoItemMessage();
}
