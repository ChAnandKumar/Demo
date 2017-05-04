package com.vjam.demo.ui.item_details;

import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.MvpView;

/**
 * Created by anand.chandaliya on 05-04-2017.
 */

public interface ShowDetailsMvpView extends MvpView {

    void displayData(Item item);
}
