package com.iwlac.tracky.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.iid.FirebaseInstanceId;
import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.adapter.TrackedProductAdapter;
import com.iwlac.tracky.adapter.TradeAdapter;
import com.iwlac.tracky.entity.Location;
import com.iwlac.tracky.entity.service.LocationService;
import com.iwlac.tracky.firebasemanager.Database;
import com.iwlac.tracky.fragment.TrackPriceDialogFragment;
import com.iwlac.tracky.models.TrackedProduct;
import com.iwlac.tracky.models.Trade;
import com.iwlac.tracky.realm.RealmManager;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class PriceCompareActivity extends AppCompatActivity {
    @BindView(R.id.rvTrade)
    RecyclerView rvTrade;
    @BindView(R.id.btnTrack)
    FloatingActionButton btnTrack;
    @BindView(R.id.imThumbnail)
    ImageView imThumbnail;

    LinearLayoutManager linearLayoutManager;
    TradeAdapter adapter;
    List<Trade> names = new ArrayList<>();
    String itemId;

    Realm mRealm;
    LocationService locationService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_compare);
        ButterKnife.bind(this);
        linearLayoutManager = new LinearLayoutManager(getBaseContext());
        rvTrade.setLayoutManager(linearLayoutManager);
        itemId = getIntent().getStringExtra("ItemId");
        adapter = new TradeAdapter(names, new ProductClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(getBaseContext(), WebDirectingActivity.class);
                startActivity(i);
            }
        });
        rvTrade.setAdapter(adapter);
        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                TrackPriceDialogFragment editNameDialogFragment = TrackPriceDialogFragment.newInstance(itemId);
                editNameDialogFragment.show(fm, "fragment_track_price");
            }
        });
        rvTrade.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0 ||dy<0 && btnTrack.isShown())
                    btnTrack.hide();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    btnTrack.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        mRealm = RealmManager.open();
        locationService = RealmManager.createLocationService();
        setUpFirebaseListener();
    }


    private void setUpFirebaseListener(){
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d("BUU", "onChildAdded:" + dataSnapshot.getKey());
                Trade item = dataSnapshot.getValue(Trade.class);
                adapter.add(item);
                    Toast.makeText(PriceCompareActivity.this, "Buu", Toast.LENGTH_SHORT).show();
                    Glide.with(getBaseContext()).load(item.getFullPicture()).into(imThumbnail);
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
            }
        };
        Database.getUpdates(itemId).addChildEventListener(childEventListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RealmManager.close();
    }
}
