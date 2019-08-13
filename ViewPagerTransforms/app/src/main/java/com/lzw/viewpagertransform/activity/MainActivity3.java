package com.lzw.viewpagertransform.activity;

import android.os.Bundle;
import android.util.Log;

import com.lzw.library.transform.banner.ITransformer;
import com.lzw.library.transform.viewpager.CustomViewPager;
import com.lzw.library.transform.widgets.FlowLayout;
import com.lzw.viewpagertransform.adapter.Main3PagerAdapter;
import com.lzw.viewpagertransform.fragment.Main3FragmentFive;
import com.lzw.viewpagertransform.fragment.Main3FragmentFour;
import com.lzw.viewpagertransform.fragment.Main3FragmentOne;
import com.lzw.viewpagertransform.fragment.Main3FragmentThree;
import com.lzw.viewpagertransform.fragment.Main3FragmentTwo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.lzw.viewpagertransform.R;

/**
 * 使用5个fragment切换
 */
public class MainActivity3 extends AppCompatActivity {

    private CustomViewPager mViewPager;
    private List<Fragment> mFragmentLists;
    private FlowLayout mFlowLayout;
    private List<String> mList;
//    private ChipGroup mChipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViewPager();
        initLayout();
    }

    private void initViewPager() {
        mViewPager = (CustomViewPager) findViewById(R.id.viewpager3);

        mFragmentLists = new ArrayList<>();
        mFragmentLists.add(Main3FragmentOne.newInstance());
        mFragmentLists.add(Main3FragmentTwo.newInstance());
        mFragmentLists.add(Main3FragmentThree.newInstance());
        mFragmentLists.add(Main3FragmentFour.newInstance());
        mFragmentLists.add(Main3FragmentFive.newInstance());

        Main3PagerAdapter main3PagerAdapter = new Main3PagerAdapter(
                getSupportFragmentManager(), mFragmentLists);

        mViewPager.setAdapter(main3PagerAdapter);
        //默认切换方式
        mViewPager.setPageTransformer(ITransformer.TRANSFORMER_DEFAULT);
        //设置两个Page之间的距离
        //mViewPager.setPageMargin(10);
        mViewPager.setScrollDirection(false);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //            当页面在滑动的时候会调用此方法，在滑动被停止之前，此方法回一直被调用。
//            其中三个参数的含义分别为：
//            position : 当前页面，及你点击滑动的页面
//            positionOffset : 当前页面偏移的百分比
//            positionOffsetPixels : 当前页面偏移的像素位置
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //            此方法是页面跳转完后被调用，arg0是你当前选中的页面的Position（位置编号）
            @Override
            public void onPageSelected(int position) {

            }

            //            此方法是在状态改变的时候调用。
//            其中state这个参数有三种状态（0，1，2）
//            state ==1的时表示正在滑动，state==2的时表示滑动完毕了，state==0的时表示什么都没做
//            当页面开始滑动的时候，三种状态的变化顺序为1-->2-->0
            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 2) {
                    //当viwpager是滑动完毕的时候，调用flowlayout监听
                    initLayoutListener(mViewPager);
                }
            }
        });
    }

    private void initLayout() {
        mFlowLayout = (FlowLayout) findViewById(R.id.flowlayout);

        mList = new ArrayList<String>();
        mList.add(getStrings(R.string.DefaultTransformer));
        mList.add(getStrings(R.string.AccordionTransformer));
        mList.add(getStrings(R.string.BackgroundToForegroundTransformer));
        mList.add(getStrings(R.string.ForegroundToBackgroundTransformer));
        mList.add(getStrings(R.string.CubeInTransformer));
        mList.add(getStrings(R.string.CubeOutTransformer));
        mList.add(getStrings(R.string.DepthPageTransformer));
        mList.add(getStrings(R.string.FlipHorizontalTransformer));
        mList.add(getStrings(R.string.FlipVerticalTransformer));
        mList.add(getStrings(R.string.RotateDownTransformer));
        mList.add(getStrings(R.string.RotateUpTransformer));
        mList.add(getStrings(R.string.StackTransformer));
        mList.add(getStrings(R.string.TabletTransformer));
        mList.add(getStrings(R.string.ScaleInOutTransformer));
        mList.add(getStrings(R.string.ZoomInTransformer));
        mList.add(getStrings(R.string.ZoomOutTranformer));
        mList.add(getStrings(R.string.ZoomOutSlideTransformer));
        mList.add(getStrings(R.string.Gallery3DTransformer));
        mList.add(getStrings(R.string.AlphaPageTransformer));

        // 添加 内容
        refreshCategorys(mFlowLayout, mList);
    }

    /**
     * 流式布局监听器
     */
    public void initLayoutListener(final CustomViewPager viewPager) {

        mFlowLayout.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                String checkedTagText = mFlowLayout.getCheckedTagText().toString();
                //打印选中的tag的文字
                Log.d("onTagClick 单选, 选择的文字是： ", checkedTagText);

                ArrayList<Integer> tagList = mFlowLayout.getCheckedTagsIndexArrayList();

                for (int i = 0; i < tagList.size(); i++) {
                    Log.d("onTagClick 单选, ", "当前位置： " + tagList.get(i));
                    initTransformerStyle(viewPager, tagList.get(i));
                }
            }
        });

    }


    private void initTransformerStyle(CustomViewPager viewPager, int currentPosition) {
        switch (currentPosition) {
            case 0:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_DEFAULT);
                break;
            case 1:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_ACCORDITION);
                break;
            case 2:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_BG_TO_FORGROUND);
                break;
            case 3:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_FORGROUND_TO_BG);
                break;
            case 4:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_CUBE_IN);
                break;
            case 5:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_CUBE_OUT);
                break;
            case 6:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_DEPTH_PAGE);
                break;
            case 7:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_FLIP_HORIZONTAL);
                break;
            case 8:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_FLIP_VERTICAL);
                break;
            case 9:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_ROTATE_DOWN);
                break;
            case 10:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_ROTATE_UP);
                break;
            case 11:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_STACK);
                break;
            case 12:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_TABLET);
                break;
            case 13:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_SCALE_IN_OUT);
                break;
            case 14:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_ZOOM_IN);
                break;
            case 15:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_ZOOM_OUT);
                break;
            case 16:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_ZOOM_OUT_SLIDE);
                break;
            case 17:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_GALLERY_3D);
                break;
            case 18:
                viewPager.setPageTransformer(ITransformer.TRANSFORMER_ALPHA_CHANGE);
                break;
        }
    }


    public void refreshCategorys(FlowLayout FlowLayout, List<String> list) {
        FlowLayout.removeAllViews();
        FlowLayout.setTags(list);
        FlowLayout.setTagsUncheckedColorAnimal(false);
    }

    private String getStrings(@StringRes int strResId) {
        return getResources().getString(strResId);
    }

}