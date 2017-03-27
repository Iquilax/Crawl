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
        wvTrade.loadUrl("https://www.facebook.com/groups/193618214469008/permalink/196896124141217/?sale_post_id=196896124141217&comment_id=196988147465348&notif_t=group_comment&notif_id=1490496509626572");
    }
}
