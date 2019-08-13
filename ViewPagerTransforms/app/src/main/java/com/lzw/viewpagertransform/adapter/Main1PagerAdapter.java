package com.lzw.viewpagertransform.adapter;


import com.lzw.viewpagertransform.fragment.Main1Fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 *  FragmentPagerAdapter它返回对应fragment中的一个章节/标签页/页面。
 *
 * 我们使用了FragmentPagerAdapter派生，它将保留每个加载的fragment在内存中
 * 如果这变得过于占用内存，最好切换到FragmentStatePagerAdapter
 */
public class Main1PagerAdapter extends FragmentPagerAdapter {

    private int[] mColorsArray;

    public Main1PagerAdapter(FragmentManager fm, int[] colorsArray) {
        super(fm);
        this.mColorsArray = colorsArray;
    }

    //这里加载是一个fragment，只是切换了里面的内容而已
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        return Main1Fragment.newInstance(mColorsArray,position);
    }

    @Override
    public int getCount() {
        return mColorsArray.length;
    }
}
