package com.iwlac.tracky.activity;

import android.animation.Animator;
import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.iwlac.tracky.R;
import com.iwlac.tracky.adapter.HomePageAdapter;
import com.iwlac.tracky.firebasemanager.backgroundservice.TrackyRSPullService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.vpHome)
    AHBottomNavigationViewPager viewPager;
    @BindView(R.id.navHome)
    AHBottomNavigation bottomNavigation;

    private int[] tabColors;
    private AHBottomNavigationAdapter navigationAdapter;
    private HomePageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();

        //get token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        TrackyRSPullService backgroundService = new TrackyRSPullService();
        Intent mServiceIntent =
                new Intent(this, TrackyRSPullService.class);



        this.startService(mServiceIntent);
    }

    private void initUI() {
        tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
        bottomNavigation.setColored(true);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                viewPager.setCurrentItem(position, false);
                return true;
            }
        });
        adapter = new HomePageAdapter(getSupportFragmentManager(),getBaseContext());
        viewPager.setAdapter(adapter);

    }
}
