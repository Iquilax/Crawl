package com.iwlac.tracky.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.iwlac.tracky.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebDirectingActivity extends AppCompatActivity {
    @BindView(R.id.wvTrade)
    WebView wvTrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_directing);
        ButterKnife.bind(this);
        wvTrade.loadUrl(getIntent().getStringExtra("url"));
    }
}
