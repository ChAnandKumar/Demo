package com.vjam.demo.util;

import android.content.res.Resources;
import android.util.TypedValue;

import com.vjam.demo.ui.home.HomeFragment;

/**
 * Created by anand.chandaliya on 24-03-2017.
 */

public class ViewUtils {

    /**
     * Converting dp to pixel
     */
    public static int dpToPx(int dp, HomeFragment context) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
