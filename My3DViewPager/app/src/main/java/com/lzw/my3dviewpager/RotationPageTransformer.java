package com.lzw.my3dviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 用ViewPager实现3D画廊效果的核心类
 */
public class RotationPageTransformer implements ViewPager.PageTransformer {
    /**
     * 最小缩放值
     */
    private static final float MIN_SCALE=0.85f;

    /**
     * 页面切换时对页面缩放旋转等动画操作的具体逻辑
     * @param page 当前View
     * @param position 当前位置
     */
    @Override
    public void transformPage(View page, float position) {
        float scaleFactor = Math.max(MIN_SCALE,1 - Math.abs(position));
        float rotate = 10 * Math.abs(position);
        //position小于等于1的时候，代表page已经位于中心item的最左边，
        //此时设置为最小的缩放率以及最大的旋转度数
        if (position <= -1){
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setRotationY(rotate);
        } else if (position < 0){//position从0变化到-1，page逐渐向左滑动
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(rotate);
        } else if (position >=0 && position < 1){//position从0变化到1，page逐渐向右滑动
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        } else if (position >= 1){//position大于等于1的时候，代表page已经位于中心item的最右边
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        }
    }
}
