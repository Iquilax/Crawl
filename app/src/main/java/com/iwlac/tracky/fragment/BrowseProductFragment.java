package com.iwlac.tracky.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.activity.PriceCompareActivity;
import com.iwlac.tracky.adapter.TrendingProductAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrowseProductFragment extends Fragment {
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.btnCrawl)
    Button btnCrawl;

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
        View view = inflater.inflate(R.layout.fragment_browse_product, container, false);
        ButterKnife.bind(this,view);
        btnCrawl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}
