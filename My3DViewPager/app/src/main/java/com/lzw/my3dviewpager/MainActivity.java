package com.lzw.my3dviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * 在这里测试一下，看看效果
 */
public class MainActivity extends AppCompatActivity implements ParamsType {
    /**
     * 网络图片url构成的String数组
     */
    String[] urlStringData = null;

    /**
     * 网络图片url构成的List集合
     */
    ArrayList<String> urlStringListData = new ArrayList<String>() {
        {
            add("http://pic1.win4000.com/pic/1/8f/a0a8710697.jpg");
            add("http://g3.hexunimg.cn/2014-11-27/170863659.jpg");
            add("http://img2.ph.126.net/SlLKQng7FwONu4Gc7840dw==/6631757159491304852.jpg");
            add("http://img2.imgtn.bdimg.com/it/u=2140906724,1420988892&fm=26&gp=0.jpg");
            add("http://www.sinaimg.cn/dy/slidenews/21_img/2013_39/2236_2506045_412924.jpg");
            add("http://img.dwstatic.com/lol/1510/309952330698/1445997581880.jpg");
            add("http://ztd00.photos.bdimg.com/ztd/w=700;q=50/sign=0b483be65de736d158138e08ab6b3eff/78310a55b319ebc4040303a38b26cffc1e171694.jpg");
            add("http://img.361games.com/file/tu/meinv/ruk1cgaqnlq.jpg");
            add("http://g1.hexunimg.cn/2014-11-27/170863665.jpg");
            add("http://img5.imgtn.bdimg.com/it/u=2418626602,1456190023&fm=26&gp=0.jpg");
            add("http://g0.hexunimg.cn/2014-11-27/170863681.jpg");
            add("http://ztd00.photos.bdimg.com/ztd/w=700;q=50/sign=8f58d3d74aa7d933bfa8e6739d70a02e/11385343fbf2b21113f86c8dc28065380dd78e1b.jpg");
            add("http://pic1.win4000.com/pic/9/c6/159c700815.jpg");
        }
    };

    /**
     * 本地图片资源id构成的数组，图片规格是960*640
     */
    private static final int[] drawableIds = new int[]{R.mipmap.ic1, R.mipmap.ic2, R.mipmap.ic3,
            R.mipmap.ic4, R.mipmap.ic5, R.mipmap.ic6, R.mipmap.ic7, R.mipmap.ic8,
            R.mipmap.ic9, R.mipmap.ic10, R.mipmap.ic11, R.mipmap.ic12, R.mipmap.ic13};

    /**
     * ViewPager
     */
    private ViewPager mViewPager;
    /**
     * NetPagerAdapter
     */
    private NetPagerAdapter mNetPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // NetPagerAdapter 加载数组图片资源
//        initViews(0);
        // NetPagerAdapter 加载List集合图片资源
        initViews(1);
        // NetPagerAdapter 加载本地图片
//        initViews(2);
    }


    /**
     * 使用NetPagerAdapter加载网络和本地图片资源
     * @param type 类型
     */
    private void initViews(int type) {
        /**
         * 给urlStringData赋值
         */
        urlStringData = new String[]{
                "http://pic1.win4000.com/pic/1/8f/a0a8710697.jpg",
                "http://g3.hexunimg.cn/2014-11-27/170863659.jpg",
                "http://img2.ph.126.net/SlLKQng7FwONu4Gc7840dw==/6631757159491304852.jpg",
                "http://img2.imgtn.bdimg.com/it/u=2140906724,1420988892&fm=26&gp=0.jpg",
                "http://www.sinaimg.cn/dy/slidenews/21_img/2013_39/2236_2506045_412924.jpg",
                "http://img.dwstatic.com/lol/1510/309952330698/1445997581880.jpg",
                "http://ztd00.photos.bdimg.com/ztd/w=700;q=50/sign=0b483be65de736d158138e08ab6b3eff/78310a55b319ebc4040303a38b26cffc1e171694.jpg",
                "http://img.361games.com/file/tu/meinv/ruk1cgaqnlq.jpg",
                "http://g1.hexunimg.cn/2014-11-27/170863665.jpg",
                "http://img5.imgtn.bdimg.com/it/u=2418626602,1456190023&fm=26&gp=0.jpg",
                "http://g0.hexunimg.cn/2014-11-27/170863681.jpg",
                "http://ztd00.photos.bdimg.com/ztd/w=700;q=50/sign=8f58d3d74aa7d933bfa8e6739d70a02e/11385343fbf2b21113f86c8dc28065380dd78e1b.jpg",
                "http://pic1.win4000.com/pic/9/c6/159c700815.jpg"
        };

        /**
         * 初始化ViewPager
         */
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        if (type == 0) {
            mNetPagerAdapter = new NetPagerAdapter(urlStringData, MainActivity.this);
        } else if (type == 1) {
            mNetPagerAdapter = new NetPagerAdapter(urlStringListData, MainActivity.this);
        } else if (type == 2) {
            mNetPagerAdapter = new NetPagerAdapter(drawableIds, MainActivity.this);
        }
        mViewPager.setAdapter(mNetPagerAdapter);
        mViewPager.setPageTransformer(true, new RotationPageTransformer());
        mViewPager.setOffscreenPageLimit(2);//设置预加载的数量，这里设置了2,会预加载中心item左边两个Item和右边两个Item
//        mViewPager.setPageMargin(5);//设置两个Page之间的距离
    }

}