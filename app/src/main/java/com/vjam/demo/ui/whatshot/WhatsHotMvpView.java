package com.vjam.demo.ui.whatshot;

import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.MvpView;

import java.util.List;

/**
 * Created by anand.chandaliya on 03-04-2017.
 */

public interface WhatsHotMvpView extends MvpView {

    void loadWhatsHotItems(List<Item> items);
}
