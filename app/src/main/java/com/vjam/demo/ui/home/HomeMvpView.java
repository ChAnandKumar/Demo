package com.vjam.demo.ui.home;

import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.MvpView;

import java.util.List;

/**
 * Created by anand.chandaliya on 24-03-2017.
 */

public interface HomeMvpView extends MvpView {

        void loadItemsInViewF(List<Item> items);
}
