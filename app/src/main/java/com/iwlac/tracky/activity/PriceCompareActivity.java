package com.iwlac.tracky.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import com.iwlac.tracky.ProductClickListener;
import com.iwlac.tracky.R;
import com.iwlac.tracky.activity.ProductDetailActivity;
import com.iwlac.tracky.adapter.TrackedProductAdapter;
import com.iwlac.tracky.adapter.TradeAdapter;
import com.iwlac.tracky.models.Trade;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PriceCompareActivity extends AppCompatActivity {
    @BindView(R.id.rvTrade)
    RecyclerView rvTrade;

    LinearLayoutManager linearLayoutManager;
    TradeAdapter adapter;
    List<Trade> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_compare);
        ButterKnife.bind(this);
        linearLayoutManager = new LinearLayoutManager(getBaseContext());
        rvTrade.setLayoutManager(linearLayoutManager);
        HashMap<String,Trade> updates = Parcels.unwrap(getIntent().getParcelableExtra("Updates"));
        names = new ArrayList<>(updates.values());
//        names.add(new Trade());
        adapter = new TradeAdapter(names, new ProductClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(getBaseContext(), WebDirectingActivity.class);
                startActivity(i);
            }
        });
        rvTrade.setAdapter(adapter);

    }


}
