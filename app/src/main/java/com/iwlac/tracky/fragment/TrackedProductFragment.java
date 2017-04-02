package com.iwlac.tracky.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.iid.FirebaseInstanceId;
import com.iwlac.tracky.activity.PriceCompareActivity;
import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.adapter.TrackedProductAdapter;
import com.iwlac.tracky.adapter.TradeAdapter;
import com.iwlac.tracky.firebasemanager.Database;
import com.iwlac.tracky.models.TrackedAttempt;
import com.iwlac.tracky.models.TrackedProduct;
import com.iwlac.tracky.models.Trade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    List<TrackedAttempt> tradeList = new ArrayList<>();

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
        ButterKnife.bind(this, view);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvTrackedProduct.setLayoutManager(linearLayoutManager);
        adapter = new TrackedProductAdapter(tradeList, new ProductClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(getContext(),PriceCompareActivity.class);
                i.putExtra("ItemId",tradeList.get(position).getId());
                startActivity(i);
            }
        });
        rvTrackedProduct.setAdapter(adapter);

        setUpFirebaseListener();
        return view;
    }

    private void setUpFirebaseListener() {
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d("BUU", "onChildAdded:" + dataSnapshot.getKey());
//                TrackedProduct product = dataSnapshot.getValue(TrackedProduct.class);
//                int position = product.getTrackedAttempses().indexOf(FirebaseInstanceId.getInstance().getToken());
//                adapter.add(product.getTrackedAttempses().get(position));
                TrackedAttempt product = new TrackedAttempt();
                product.setPrice(20000);
                product.setTrackedPlaces(new ArrayList<String>());
                adapter.add(product);
                tradeList.add(product);
                adapter.add(product);
                tradeList.add(product);
                adapter.add(product);
                tradeList.add(product);
                adapter.add(product);
                tradeList.add(product);
                adapter.add(product);
                tradeList.add(product);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d("Buu", "onChildChanged:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                TrackedProduct newComment = dataSnapshot.getValue(TrackedProduct.class);
                String commentKey = dataSnapshot.getKey();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d("Buu", "onChildRemoved:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d("BUU", "onChildMoved:" + dataSnapshot.getKey());

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                TrackedProduct movedComment = dataSnapshot.getValue(TrackedProduct.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Buu", "postComments:onCancelled", databaseError.toException());
                Toast.makeText(getContext(), "Failed to load comments.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        Database.getProduct().addChildEventListener(childEventListener);
    }

}
