package com.lzw.myapplication;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 垂直滑动的ViewPager
 * Created by lzw on 2017/6/1
 */
public class MyViewPager extends ViewPager {
    /**
     * 垂直滑动的ViewPager 构造函数
     *
     * @param context 上下文
     */
    public MyViewPager(Context context) {
        this(context, null);
    }

    /**
     * 垂直滑动的ViewPager 构造函数
     *
     * @param context 上下文
     * @param attrs   自定义属性
     */
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        //设置viewpage的切换动画,这里设置才能真正实现垂直滑动的viewpager
        setPageTransformer(true, new DefaultTransformer());
    }

    /**
     * 拦截touch事件
     *
     * @param ev 获取事件类型的封装类MotionEvent
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = super.onInterceptTouchEvent(swapEvent(ev));
        swapEvent(ev);
        return intercept;
    }


    /**
     * 触摸点击触发该方法
     *
     * @param ev 获取事件类型的封装类MotionEvent
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapEvent(ev));
    }

    /**
     * 交换x轴和y轴的移动距离
     *
     * @param event 获取事件类型的封装类MotionEvent
     */
    private MotionEvent swapEvent(MotionEvent event) {
        //获取宽高
        float width = getWidth();
        float height = getHeight();
        //将Y轴的移动距离转变成X轴的移动距离
        float swappedX = (event.getY() / height) * width;
        //将X轴的移动距离转变成Y轴的移动距离
        float swappedY = (event.getX() / width) * height;
        //重设event的位置
        event.setLocation(swappedX, swappedY);
        return event;
    }


    /**
     * 自定义 ViewPager 切换动画
     * 如果不设置切换动画，还会是水平方向的动画
     */
    public class DefaultTransformer implements ViewPager.PageTransformer {
        public static final String TAG = "simple";

        @Override
        public void transformPage(View view, float position) {
            float alpha = 0;
            if (0 <= position && position <= 1) {
                alpha = 1 - position;
            } else if (-1 < position && position < 0) {
                alpha = position + 1;
            }
            view.setAlpha(alpha);
            float transX = view.getWidth() * -position;
            view.setTranslationX(transX);
            float transY = position * view.getHeight();
            view.setTranslationY(transY);
        }
    }
}
