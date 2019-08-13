package com.lzw.viewpagertransform.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lzw.library.transform.widgets.FlowLayout;
import com.lzw.viewpagertransform.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by lzw on 2018/5/18
 */

public class FlowLayoutSampleActivity extends AppCompatActivity {

    private FlowLayout fldefault;
    private FlowLayout flred,flred2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        this.flred = (FlowLayout) findViewById(R.id.fl_red);
        this.flred2 = (FlowLayout) findViewById(R.id.fl_red2);
        this.fldefault = (FlowLayout) findViewById(R.id.fl_default);

        final List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("web前端");
        list.add("PHP");
        list.add("Android");
        list.add("ios");
        list.add("react native开发");
        list.add("UI工程师");
        list.add("测试工程师");
        list.add("C硬件工程师");
        list.add("C++硬件工程师");
        list.add("Python人工智能");
        list.add("大数据工程师");
        list.add("算法工程师");
        list.add("运维工程师");
        list.add("全栈工程师");
        list.add("架构师");
        list.add("产品经理");
        list.add("项目经理");
        refreshCategorys(fldefault, list);
        refreshCategorys(flred, list);
        refreshCategorys(flred2, list);

        fldefault.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                Log.d("onTagClick 绿色多选", fldefault.getCheckedTagsTextsArrayList().toString());

                ArrayList<Integer> tagList = fldefault.getCheckedTagsIndexArrayList();
                String mCategory = "";
                for (int i = 0; i < tagList.size(); i++) {
                    mCategory += list.get(tagList.get(i)) + ",";
                }
                Log.d("onTagClick 绿色多选","mCategory: "+ mCategory +"    taglist："+tagList);
            }
        });

        flred.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                Log.v("onTagClick 粉红色单选", flred.getCheckedTagsTextsArrayList().toString());

                ArrayList<Integer> tagList = flred.getCheckedTagsIndexArrayList();
                String mCategory = "";
                for (int i = 0; i < tagList.size(); i++) {
                    mCategory += list.get(tagList.get(i)) + ",";
                }
                Log.d("onTagClick 粉红色单选","mCategory: "+ mCategory +"    taglist："+tagList);
            }
        });

        flred2.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                Log.e("onTagClick 粉红色多选", flred2.getCheckedTagsTextsArrayList().toString());

                ArrayList<Integer> tagList = flred2.getCheckedTagsIndexArrayList();
                String mCategory = "";
                for (int i = 0; i < tagList.size(); i++) {
                    mCategory += list.get(tagList.get(i)) + ",";
                }
                Log.d("onTagClick 粉红色多选","mCategory: "+ mCategory +"    taglist："+tagList);
            }
        });

        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fldefault.setTagsUncheckedColorAnimal(true);
                flred.setTagsUncheckedColorAnimal(true);
                flred2.setTagsUncheckedColorAnimal(true);
            }
        });

    }

    public void refreshCategorys(FlowLayout FlowLayout,List<String> list) {
        FlowLayout.removeAllViews();
        FlowLayout.setTags(list);
        FlowLayout.setTagsUncheckedColorAnimal(false);

    }

}
