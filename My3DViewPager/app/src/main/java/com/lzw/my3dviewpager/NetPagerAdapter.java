package com.lzw.my3dviewpager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * 描述：ViewPager的适配器，可以加载网络、本地图片
 */
public class NetPagerAdapter extends PagerAdapter implements ParamsType{

//    Glide基础使用：
//    Glide.with(activity)
//        // 可以调用asBitmap() ，获得一个 BitmapRequestBuilder 对象,默认资源类型是Drawable
//        .asBitmap()
//        .load(url)
//        // 转换
//        .apply(RequestOptions.centerCropTransform())
//        // 淡入淡出过渡
//        .transition(BitmapTransitionOptions.withCrossFade())
//        // 加载图片，缩略图会在主请求加载过程中展示，如果主请求完成，缩略图将不会被展示
//        .thumbnail(Glide.with(activity).load(thumbnailUrl))
//        .into(imageView);


    /**
     * 网络图片url构成的String数组
     */
    private String[] mUrlData;
    /**
     * 网络图片url构成的List集合
     */
    private List<String> mUrlData2;
    /**
     *  本地图片资源id构成的数组
     */
    private int[] mBitmapIds;
    /**
     * 上下文
     */
    private Activity mContext;
    /**
     * RequestBuilder对象
     */
    private RequestBuilder<Bitmap> mRequestBuilder;
    /**
     * 类型
     */
    private int mType;

    /**
     *
     * @param urlData 网络图片url构成的String数组
     * @param context 上下文
     */
    public NetPagerAdapter(String[] urlData, Activity context) {
        this.mUrlData = urlData;
        this.mContext = context;
        mType = ParamsType.TYPE_STRING_ARRAY;
    }

    /**
     *
     * @param urlData2 网络图片url构成的List集合
     * @param context 上下文
     */
    public NetPagerAdapter(List<String> urlData2, Activity context) {
        this.mUrlData2 = urlData2;
        this.mContext = context;
        mType = ParamsType.TYPE_STRING_LIST;
    }


    /**
     *
     * @param bitmapIds  传入的本地图片资源id构成的数组
     * @param context 上下文
     */
    public NetPagerAdapter(int[] bitmapIds, Activity context) {
        this.mBitmapIds = bitmapIds;
        this.mContext = context;
        mType = ParamsType.TYPE_INT_ARRAY;
    }

    /**
     * 获取传入的是哪种类型
     * @return  type 类型
     */
    private int getTypes(){
        return mType;
    }



    @Override
    public int getCount() {
        if(getTypes()== ParamsType.TYPE_STRING_ARRAY && mUrlData!=null){
            return mUrlData.length;
        } else if(getTypes()== ParamsType.TYPE_STRING_LIST && mUrlData2!=null){
            return mUrlData2.size();
        }else if(getTypes()== ParamsType.TYPE_INT_ARRAY && mBitmapIds!=null){
            return mBitmapIds.length;
        } else if(mUrlData==null && mUrlData2==null && mBitmapIds==null){
            throw new IllegalArgumentException("mUrlData、mUrlData2和mBitmapIds不能同时为空");
        }
        return -1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        initRequestBuilder(mContext);
        if(getTypes()== ParamsType.TYPE_STRING_ARRAY && mUrlData!=null){
            loadArrayPictures(position, mUrlData, imageView);
        } else if(getTypes()== ParamsType.TYPE_STRING_LIST && mUrlData2!=null){
             loadListUrlPictures(position, mUrlData2, imageView);
        }else if(getTypes()== ParamsType.TYPE_INT_ARRAY && mBitmapIds!=null){
             loadArrayLocalPictures(position, mBitmapIds, imageView);
        } else if(mUrlData==null && mUrlData2==null && mBitmapIds==null){
            throw new IllegalArgumentException("mUrlData、mUrlData2和mBitmapIds不能同时为空");
        }
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }



    /**
     * 初始化RequestBuilder
     * @param activity Activity对象
     * @return RequestBuilder对象
     */
    private RequestBuilder initRequestBuilder(Activity activity){
        try{
            RequestOptions requestOptions = new RequestOptions()
                    // 占位图
//                .placeholder()
                    // 加载错误之后的错误图
                .error(R.mipmap.ic_launcher)
                    // 指定图片尺寸，多数情况下不需要指定图片大小
                .override(1080,1920 )
                    // 图片缩放类型 等比例缩放
//                    .fitCenter()
                    // 等比例缩放,当图片的宽高都大于等于ImageView的宽高时，截取中间的显示
//                .centerCrop()
                    // 将图片的内容完整居中显示
//                .centerInside()
                    // 把图片按比例扩大/缩小到View的宽度，居中显示
//                .fitCenter()
                    // 图片缩放类型：圆形
//                .circleCrop()
                    // 参数为true表示跳过内存缓存
//                .skipMemoryCache(true)
                    // 缓存所有版本的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                    // 跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                    // 只缓存原来分辨率的图片
//                .diskCacheStrategy(DiskCacheStrategy.DATA)
                    // 只缓存最终的图片
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    // 根据图片资源智能地选择使用哪一种缓存策略（默认选项
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    ;
            mRequestBuilder = Glide.with(activity).asBitmap()
                    // 转换
                    .apply(requestOptions)
                    // 淡入淡出过渡
                    .transition(BitmapTransitionOptions.withCrossFade())
                    ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return mRequestBuilder;
    }

    /**
     * 加载数组url图片资源
     * @param urlData 网络图片url构成的String数组
     * @param imageView ImageView对象
     */
    private void loadArrayPictures(int position,String[] urlData,ImageView imageView){
        for (int i = 0; i < urlData.length; i++){
            String url = urlData[position%urlData.length];
            // 加载图片url
            mRequestBuilder.load(url)
                    // 失败时开始新的请求
//                    .error(mRequestBuilder.load(url))
                    .into(imageView);
        }
    }

    /**
     * 加载List url图片资源
     * @param urlData 网络图片url构成的List集合
     * @param imageView ImageView对象
     */
    private void loadListUrlPictures(int position, List<String> urlData,ImageView imageView){
        for (int i = 0; i < urlData.size(); i++){
            String url = urlData.get(position%urlData.size());
            // 加载图片url
            mRequestBuilder.load(url)
                    // 失败时开始新的请求
//                    .error(mRequestBuilder.load(url))
                    .into(imageView);
        }
    }

    /**
     * 加载本地图片资源
     * @param localData 本地图片资源id构成的数组
     * @param imageView ImageView对象
     */
    private void loadArrayLocalPictures(int position,int[] localData,ImageView imageView){
        for (int i = 0; i < localData.length; i++){
            int resourceId = localData[position%localData.length];
            // 加载图片url
            mRequestBuilder.load(resourceId)
                    // 失败时开始新的请求
//                    .error(mRequestBuilder.load(resourceId))
                    .into(imageView);
        }
    }



}
