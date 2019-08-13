package com.lzw.viewpagertransform.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.viewpager.widget.PagerAdapter;

/**
 * MainActivity2对应的 PagerAdapter
 */
public class Main2PagerAdapter extends PagerAdapter {

    private List<View> pageList;//传入的页面集合

    public Main2PagerAdapter(List<View> list){
        this.pageList = list;
    }

    @Override
    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(pageList.get(position));
        return pageList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
