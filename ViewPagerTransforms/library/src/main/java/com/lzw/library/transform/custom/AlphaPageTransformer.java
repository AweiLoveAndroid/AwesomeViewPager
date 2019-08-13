package com.lzw.library.transform.custom;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 *  透明度变换
 */
public class AlphaPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        if (position < -1) { // [-Infinity,-1)
            page.setAlpha(0);
        } else if (position <= 0) { // [-1,0]
            page.setAlpha(position+1);
            page.setTranslationX(0);
        } else if (position <= 1) { // (0,1]
            page.setAlpha(1 - position);
            page.setTranslationX(pageWidth * -position);
        } else { // (1,+Infinity]
            page.setAlpha(0);
        }
    }
}
