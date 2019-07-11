# My3DViewPager

### 介绍：

> 自定义ViewPager实现3D画廊效果

----

### 更新记录

2019.05.15
 * 1.删掉MyPagerAdapter，换成了NetPagerAdapter类。
 * 2.新增网络图片Api
 * 3.使用Glide加载网络图片
 * 4.保留原有的加载本地图片功能，并封装在NetPagerAdapter类中，便于调用。

2018.1.18
 * 1.MyPagerAdapter类是ViewPager适配器，封装了使用AsyncTask异步加载本地图片，同时使用BitmapFactory处理图片，使用LruCache做缓存处理。
 * 2.RotationPageTransformer类是核心类，用于实现3D画廊效果。

----

### 相关API说明


> 构造函数：

api|介绍|示例
----|----|----
NetPagerAdapter(String[] urlData, Activity context)|参数1：网络图片url构成的String数组|new NetPagerAdapter(new String[]{"xxx","xxx"}, MainActivity.this);
NetPagerAdapter(List<String> urlData2, Activity context)|网络图片url构成的List集合|new NetPagerAdapter(new ArrayList(){add("xxx");add("xxx");}, MainActivity.this);
NetPagerAdapter(int[] bitmapIds, Activity context)|参数1：本地图片资源id构成的数组|new NetPagerAdapter(new int[]{R.mipmap.ic1, R.mipmap.ic2},MainActivity.this);

> 普通方法

api|介绍|示例
----|----|----
RequestBuilder initRequestBuilder(Activity activity)|初始化RequestBuilder| initRequestBuilder(mContext);
void loadArrayPictures(int position,String[] urlData,ImageView imageView)|加载数组url图片资源|loadArrayPictures(position, mUrlData, imageView);
voidl oadListUrlPictures(int position, List<String> urlData,ImageView imageView)|加载List url图片资源|loadListUrlPictures(position, mUrlData2, imageView);
void loadArrayLocalPictures(int position,int[] localData,ImageView imageView)|加载本地图片资源|loadArrayLocalPictures(position, mBitmapIds, imageView);

----

### 更多详细文档请点击：  **[https://aweiloveandroid.github.io/My3DViewPager/](https://aweiloveandroid.github.io/My3DViewPager/)**

----

### 示例代码如下：

```
public class MainActivity extends AppCompatActivity  {

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

    private ViewPager mViewPager;
    private NetPagerAdapter mNetPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // NetPagerAdapter加载List集合图片资源
        initViews();

    }
	
	/**
	 *   加载List url图片资源
	 */
	private void initViews(){
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mNetPagerAdapter = new NetPagerAdapter(urlStringListData, MainActivity.this);
        mViewPager.setAdapter(mNetPagerAdapter);
        mViewPager.setPageTransformer(true, new RotationPageTransformer());
        mViewPager.setOffscreenPageLimit(2);//设置预加载的数量，这里设置了2,会预加载中心item左边两个Item和右边两个Item
		mViewPager.setPageMargin(5);//设置两个Page之间的距离
    }
}
```

----

### 示例图如下所示：

![示例图](https://github.com/AweiLoveAndroid/My3DViewPager/blob/master/pic/logo.gif?raw=true)