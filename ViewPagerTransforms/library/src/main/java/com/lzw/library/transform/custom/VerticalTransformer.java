package com.lzw.library.transform.custom;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * 垂直方向的PageTransformer
 */
public class VerticalTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        float alpha = 0;
        if(alpha>= 0 && alpha <= 1){
            alpha = 1 - position;
        }else if(alpha>= -1 && alpha < 0){
            alpha = 1 + position;
        }
        page.setAlpha(alpha);
        float transX = page.getWidth() * -position;
        page.setTranslationX(transX);
        float transY = position * page.getHeight();
        page.setTranslationY(transY);

    }
}
