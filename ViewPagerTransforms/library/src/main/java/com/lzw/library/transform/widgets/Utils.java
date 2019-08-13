package com.lzw.library.transform.widgets;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by luzhaowei on 2018/5/19 0019.
 */

public class Utils {

    public static float dp2px(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }
}