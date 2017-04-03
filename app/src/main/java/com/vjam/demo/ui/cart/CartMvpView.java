package com.vjam.demo.ui.cart;

import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.MvpView;

import java.util.List;

/**
 * Created by anand.chandaliya on 03-04-2017.
 */

public interface CartMvpView extends MvpView {
    void loadCartList(List<Item> items);
    void showCartEmptyMessage(String message);
}
