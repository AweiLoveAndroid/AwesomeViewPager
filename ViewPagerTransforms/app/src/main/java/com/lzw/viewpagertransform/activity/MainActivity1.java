package com.lzw.viewpagertransform.activity;

import android.os.Bundle;

import com.lzw.viewpagertransform.R;
import com.lzw.viewpagertransform.adapter.Main1PagerAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

/**
 * 使用一个fragment，只是当前内容局部切换。
 */
public class MainActivity1 extends AppCompatActivity {

    private Main1PagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        int[] colorsArray = new int[]{R.color.blue,R.color.colorAccent,R.color.colorPrimary};
        mSectionsPagerAdapter = new Main1PagerAdapter(getSupportFragmentManager(),colorsArray);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

}
