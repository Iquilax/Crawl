package com.iwlac.tracky.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iwlac.tracky.activity.PriceCompareActivity;
import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.adapter.TrackedProductAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackedProductFragment extends Fragment {
    @BindView(R.id.rvTrackedProduct)
    RecyclerView rvTrackedProduct;

    LinearLayoutManager linearLayoutManager;
    TrackedProductAdapter adapter;
    List<String> names;

    public TrackedProductFragment() {
        // Required empty public constructor
    }

    public static TrackedProductFragment newInstance() {
        TrackedProductFragment fragment = new TrackedProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tracked_product, container, false);
        ButterKnife.bind(this,view);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvTrackedProduct.setLayoutManager(linearLayoutManager);
        names = new ArrayList<>();
        names.add("Iphone 6");
        names.add("Macbook Pro 13inch Grey");
        names.add("Nexus 6XXX");
        adapter = new TrackedProductAdapter(names, new ProductClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(getContext(), PriceCompareActivity.class);
                startActivity(i);
            }
        });
        rvTrackedProduct.setAdapter(adapter);

        rvTrackedProduct.addItemDecoration(new DividerItemDecoration(rvTrackedProduct.getContext(), DividerItemDecoration.VERTICAL));


        return view;
    }

}
