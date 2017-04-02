package com.iwlac.tracky.fragment;


import android.content.Intent;
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
import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.activity.PriceCompareActivity;
import com.iwlac.tracky.adapter.TrendingProductAdapter;
import com.iwlac.tracky.firebasemanager.Database;
import com.iwlac.tracky.models.TrackedProduct;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotProductFragment extends Fragment{
    @BindView(R.id.rvHotProduct)
    RecyclerView rvHotProduct;

    LinearLayoutManager linearLayoutManager;
    TrendingProductAdapter adapter;
    private List<TrackedProduct> productList = new ArrayList<>();

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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot_product, container, false);
        ButterKnife.bind(this,view);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvHotProduct.setLayoutManager(linearLayoutManager);
        adapter = new TrendingProductAdapter(productList, new ProductClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(getContext(), PriceCompareActivity.class);
                i.putExtra("ItemId", productList.get(position).getId());
                startActivity(i);
            }
        });
        rvHotProduct.setAdapter(adapter);
//        adapter.add(new TrackedProduct("Buu"));
        setUpFirebaseListener();

        return view;
    }

    private void setUpFirebaseListener(){
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d("BUU", "onChildAdded:" + dataSnapshot.getKey());
                TrackedProduct product = dataSnapshot.getValue(TrackedProduct.class);
                product.setId(dataSnapshot.getKey());
                adapter.add(product);
                adapter.add(product);
                adapter.add(product);
                adapter.add(product);
                adapter.add(product);
                adapter.add(product);
                adapter.add(product);
                adapter.add(product);
                adapter.add(product);


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
