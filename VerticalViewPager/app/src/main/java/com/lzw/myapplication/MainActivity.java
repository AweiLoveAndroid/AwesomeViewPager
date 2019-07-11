package com.lzw.myapplication;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

/**
 * 垂直的ViewPager演示
 * @author Create by lzw on 2017/6/1
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 自定义的垂直的ViewPager {@link MyAdapter}
     */
    private MyViewPager mViewPager;

    /**
     * 创建
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无标题栏：
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏：
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();

    }

    /**
     * 初始化View控件
     */
    private void initView() {
        mViewPager = (MyViewPager) findViewById(R.id.viewPager);

        ArrayList<View> viewLists = new ArrayList<View>();
        viewLists.add(getLayoutInflater().inflate(R.layout.view_one, null, false));
        viewLists.add(getLayoutInflater().inflate(R.layout.view_two, null, false));
        viewLists.add(getLayoutInflater().inflate(R.layout.view_three, null, false));
        viewLists.add(getLayoutInflater().inflate(R.layout.view_four, null, false));

        mViewPager.setAdapter(new MyAdapter(viewLists));

    }

    /**
     * ViewPager的适配器
     */
    class MyAdapter extends PagerAdapter {
        /**
         * view的集合
         */
        private ArrayList<View> viewLists;

        /**
         * ViewPager的构造函数
         * @param viewLists 传入的View的集合，用于展示这些视图
         */
        public MyAdapter(ArrayList<View> viewLists) {
            super();
            this.viewLists = viewLists;
        }

        /**
         * 获取要滑动的控件的数量
         */
        @Override
        public int getCount() {
            return viewLists.size();
        }

        /**
         * 判断显示的是否是同个控件，一般将两个参数相比较返回即可
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * PagerAdapter只缓存三个页面，如果滑动的页面超出了缓存的范围，
         * 就会调用这个方法，将页面销毁
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewLists.get(position));
            return viewLists.get(position);
        }

        /**
         * 当要显示的页面可以进行缓存的时候，会调用这个方法进行显示页面的初始化，
         * 我们将要显示的控件(viewLists.get(position)从集合中获取View)加入到ViewGroup中，然后作为返回值返回即可
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewLists.get(position));
        }
    }
}