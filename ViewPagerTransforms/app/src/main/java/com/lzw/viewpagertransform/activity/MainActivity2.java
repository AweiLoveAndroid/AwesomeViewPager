package com.lzw.viewpagertransform.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.lzw.library.transform.banner.AccordionTransformer;
import com.lzw.viewpagertransform.R;
import com.lzw.viewpagertransform.adapter.Main2PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

/**
 * viewpager加载3个layout，进行切换
 */
public class MainActivity2 extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager2);

        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.vp_layout1, null);
        View view2 = inflater.inflate(R.layout.vp_layout2,null);
        View view3 = inflater.inflate(R.layout.vp_layout3, null);

        List<View> pageList = new ArrayList<>();
        pageList.add(view1);
        pageList.add(view2);
        pageList.add(view3);

        mViewPager.setAdapter(new Main2PagerAdapter(pageList));

        mViewPager.setPageTransformer(false,new AccordionTransformer());
    }

}
