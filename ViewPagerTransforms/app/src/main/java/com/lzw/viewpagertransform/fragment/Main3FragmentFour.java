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
public class Main3FragmentFour extends Fragment {

    public Main3FragmentFour() {
    }

    public static Main3FragmentFour newInstance() {
        Main3FragmentFour fragment = new Main3FragmentFour();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vp_layout4, container, false);
    }

}
