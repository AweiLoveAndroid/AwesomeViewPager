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
public class Main3FragmentTwo extends Fragment {

    public Main3FragmentTwo() {
    }

    public static Main3FragmentTwo newInstance() {
        Main3FragmentTwo fragment = new Main3FragmentTwo();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vp_layout2, container, false);
    }


}
