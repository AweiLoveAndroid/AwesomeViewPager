package com.lzw.library.transform.viewpager;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.lzw.library.transform.banner.AccordionTransformer;
import com.lzw.library.transform.banner.BackgroundToForegroundTransformer;
import com.lzw.library.transform.banner.CubeInTransformer;
import com.lzw.library.transform.banner.CubeOutTransformer;
import com.lzw.library.transform.banner.DefaultTransformer;
import com.lzw.library.transform.banner.DepthPageTransformer;
import com.lzw.library.transform.banner.FlipHorizontalTransformer;
import com.lzw.library.transform.banner.FlipVerticalTransformer;
import com.lzw.library.transform.banner.ForegroundToBackgroundTransformer;
import com.lzw.library.transform.banner.ITransformer;
import com.lzw.library.transform.banner.RotateDownTransformer;
import com.lzw.library.transform.banner.RotateUpTransformer;
import com.lzw.library.transform.banner.ScaleInOutTransformer;
import com.lzw.library.transform.banner.StackTransformer;
import com.lzw.library.transform.banner.TabletTransformer;
import com.lzw.library.transform.banner.ZoomInTransformer;
import com.lzw.library.transform.banner.ZoomOutSlideTransformer;
import com.lzw.library.transform.banner.ZoomOutTranformer;
import com.lzw.library.transform.custom.AlphaPageTransformer;
import com.lzw.library.transform.custom.Gallery3DTransformer;

import androidx.viewpager.widget.ViewPager;

/**
 *
 * 自定义的ViewPager
 *
 * 跟原生相比，新增功能有2个：
 *     1.新增setPageTransformer方法，可以指定使用哪种Transformer
 *     2.新增设置ViewPager的绘制方向，可以任意切换垂直滑动还是水平滑动。
 *
 */

public class CustomViewPager extends ViewPager {

    private static final String TAG = "CustomViewPager";

    private boolean flag = false;//判断是否是垂直方向

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     *
     * @param reverseDrawingOrder 如果所提供的PageTransformer需要从最后到第一个页面视图，返回true
     *                            从第一个到最后一个页面，则返回false
     * @param transformer
     */
    @Override
    public void setPageTransformer(boolean reverseDrawingOrder, PageTransformer transformer) {
        super.setPageTransformer(reverseDrawingOrder, transformer);
    }

    protected void setPageTransformer(Class<? extends PageTransformer> transformer) {
        try {
            setPageTransformer(true, transformer.newInstance());
        } catch (Exception e) {
            Log.e(TAG, "Please set the PageTransformer class");
        }
    }

    /**
     * 设置transformer类型
     * @param transformerStyle  类型参数
     *
     * 例如：setPageTransformer(ITransformer.TRANSFORMER_DEFAULT)
     */
    public void setPageTransformer(int transformerStyle) {
        try {
            initTransformerStyle(transformerStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTransformerStyle(int transformerStyle){
        switch (transformerStyle){
            case ITransformer.TRANSFORMER_DEFAULT:// 默认
                setPageTransformer(DefaultTransformer.class);
                break;
            case ITransformer.TRANSFORMER_ACCORDITION:// 折叠
                setPageTransformer(AccordionTransformer.class);
                break;
            case ITransformer.TRANSFORMER_BG_TO_FORGROUND:// 后到前
                setPageTransformer(BackgroundToForegroundTransformer.class);
                break;
            case ITransformer.TRANSFORMER_FORGROUND_TO_BG:// 前到后
                setPageTransformer(ForegroundToBackgroundTransformer.class);
                break;
            case ITransformer.TRANSFORMER_CUBE_IN:// 立体进入
                setPageTransformer(CubeInTransformer.class);
                break;
            case ITransformer.TRANSFORMER_CUBE_OUT:// 立体退出
                setPageTransformer(CubeOutTransformer.class);
                break;
            case ITransformer.TRANSFORMER_DEPTH_PAGE:// 深度页面
                setPageTransformer(DepthPageTransformer.class);
                break;
            case ITransformer.TRANSFORMER_FLIP_HORIZONTAL:// 水平翻转
                setPageTransformer(FlipHorizontalTransformer.class);
                break;
            case ITransformer.TRANSFORMER_FLIP_VERTICAL:// 垂直翻转
                setPageTransformer(FlipVerticalTransformer.class);
                break;
            case ITransformer.TRANSFORMER_ROTATE_DOWN:// 向下旋转
                setPageTransformer(RotateDownTransformer.class);
                break;
            case ITransformer.TRANSFORMER_ROTATE_UP:// 向上旋转
                setPageTransformer(RotateUpTransformer.class);
                break;
            case ITransformer.TRANSFORMER_STACK:// 叠加
                setPageTransformer(StackTransformer.class);
                break;
            case ITransformer.TRANSFORMER_TABLET:// 方块
                setPageTransformer(TabletTransformer.class);
                break;
            case ITransformer.TRANSFORMER_SCALE_IN_OUT:// 放大进出
                setPageTransformer(ScaleInOutTransformer.class);
                break;
            case ITransformer.TRANSFORMER_ZOOM_IN:// 放大
                setPageTransformer(ZoomInTransformer.class);
                break;
            case ITransformer.TRANSFORMER_ZOOM_OUT:// 缩小
                setPageTransformer(ZoomOutTranformer.class);
                break;
            case ITransformer.TRANSFORMER_ZOOM_OUT_SLIDE:// 外面缩小
                setPageTransformer(ZoomOutSlideTransformer.class);
                break;
            case ITransformer.TRANSFORMER_GALLERY_3D:// 3D画廊
                setPageTransformer(Gallery3DTransformer.class);
                break;
            case ITransformer.TRANSFORMER_ALPHA_CHANGE:// 透明度变化
                setPageTransformer(AlphaPageTransformer.class);
                break;
        }
    }


    /**
     * 拦截touch事件
     *
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(getScrollDirection()){//垂直方向
            boolean intercept = super.onInterceptTouchEvent(swapEvent(ev));
            swapEvent(ev);
            return intercept;
        }else{
            return super.onInterceptTouchEvent(ev);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(getScrollDirection()){//垂直方向
            return super.onTouchEvent(swapEvent(ev));
        }else{
            return super.onTouchEvent(ev);
        }
    }

    /***
     * 交换X和Y的移动距离的值
     * @param event 事件
     * @return
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
     * 设置滑动方向
     * @param direction  true为垂直方向 ,false 水平方向
     */
    public void setScrollDirection(boolean direction){
        flag = direction;
        if(direction == true){
            flag = true;
        }else{
            flag = false;
        }
    }

    public boolean getScrollDirection(){
        return flag;
    }



}
