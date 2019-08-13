package com.lzw.viewpagertransform.adapter;


import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * MainActivity3所使用的FragmentPagerAdapter
 */
public class Main3PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentLists = new ArrayList();

    public Main3PagerAdapter(FragmentManager fm, List<Fragment> fragmentLists) {
        super(fm);
        this.mFragmentLists = fragmentLists;
    }

    //这里加载是一个fragment集合，根据position，自动去切换fragment
    @Override
    public Fragment getItem(int position) {
        return mFragmentLists.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentLists.size();
    }
}
