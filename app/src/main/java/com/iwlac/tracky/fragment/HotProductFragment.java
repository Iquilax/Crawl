package com.iwlac.tracky.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iwlac.tracky.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotProductFragment extends Fragment {


    public HotProductFragment() {
        // Required empty public constructor
    }

    public static HotProductFragment newInstance() {
        HotProductFragment fragment = new HotProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot_product, container, false);
    }

}
