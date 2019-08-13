package com.lzw.viewpagertransform.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzw.viewpagertransform.R;

import androidx.fragment.app.Fragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main1Fragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String TAG_CURRENT_COLOR = "current_bgcolor";

    private static final String TAG_CURRENT_POSITION = "current_position";


    private RelativeLayout mRootLayout;
    private ImageView mLeftImageView;
    private ImageView mRightImageView;
    private View mRootView;
    private TextView mCenterTextView;

    public Main1Fragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     * @param resColor 背景颜色资源
     * @param position 当前页面的位置
     */
    public static Main1Fragment newInstance(int[] resColor, int position) {
        Main1Fragment fragment = new Main1Fragment();
        Bundle args = new Bundle();
        args.putIntArray(TAG_CURRENT_COLOR, resColor);
        args.putInt(TAG_CURRENT_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main1, container, false);
        mRootLayout = (RelativeLayout) mRootView.findViewById(R.id.root_layout);
        mLeftImageView = (ImageView) mRootLayout.findViewById(R.id.iv_left);
        mRightImageView = (ImageView) mRootLayout.findViewById(R.id.iv_right);
        mCenterTextView = (TextView) mRootLayout.findViewById(R.id.tv_center);

        initLayout();

        return mRootView;
    }


    /**
     * 设置布局内容
     */
    private void initLayout(){
        int[] getIntArray = getArguments().getIntArray(TAG_CURRENT_COLOR);
        for (int i =0;i<getIntArray.length;i++){
            int currentPosition = getArguments().getInt(TAG_CURRENT_POSITION);
            if (currentPosition == 0){
                mLeftImageView.setVisibility(View.GONE);
                mRightImageView.setVisibility(View.VISIBLE);
            }else if(currentPosition == getIntArray.length-1){
                mLeftImageView.setVisibility(View.VISIBLE);
                mRightImageView.setVisibility(View.GONE);
            }else {
                mLeftImageView.setVisibility(View.VISIBLE);
                mRightImageView.setVisibility(View.VISIBLE);
            }
            mCenterTextView.setText("当前页面：Page " + (currentPosition+1));
            mRootLayout.setBackgroundColor(
                    getResources().getColor(getIntArray[i]));
        }
    }




}
