package com.lzw.viewpagertransform.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.lzw.viewpagertransform.R;

/**
 *
 */
public class Main3FragmentFive extends Fragment {

    public Main3FragmentFive() {
    }

    public static Main3FragmentFive newInstance() {
        Main3FragmentFive fragment = new Main3FragmentFive();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vp_layout5, container, false);
    }

}
