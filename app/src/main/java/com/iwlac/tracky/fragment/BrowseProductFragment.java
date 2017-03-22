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
public class BrowseProductFragment extends Fragment {


    public BrowseProductFragment() {
        // Required empty public constructor
    }

    public static BrowseProductFragment newInstance() {
        BrowseProductFragment fragment = new BrowseProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse_product, container, false);
    }

}