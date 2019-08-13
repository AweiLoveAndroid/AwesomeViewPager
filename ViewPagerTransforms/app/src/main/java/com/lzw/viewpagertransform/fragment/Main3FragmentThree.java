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
public class Main3FragmentThree extends Fragment {

    public Main3FragmentThree() {
    }

    public static Main3FragmentThree newInstance() {
        Main3FragmentThree fragment = new Main3FragmentThree();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vp_layout3, container, false);
    }

}
