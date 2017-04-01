package com.iwlac.tracky.activity;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.iwlac.tracky.R;
import com.iwlac.tracky.adapter.HomePageAdapter;
import com.iwlac.tracky.entity.Item;
import com.iwlac.tracky.entity.Trade;
import com.iwlac.tracky.entity.Updates;
import com.iwlac.tracky.entity.service.TradeService;
import com.iwlac.tracky.realm.RealmManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity {
    @BindView(R.id.vpHome)
    AHBottomNavigationViewPager viewPager;
    @BindView(R.id.navHome)
    AHBottomNavigation bottomNavigation;

    FirebaseAuth mAuth;
    private int[] tabColors;
    private AHBottomNavigationAdapter navigationAdapter;
    private HomePageAdapter adapter;

    private Realm mRealm;
    private TradeService tradeService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
        initData();

        //Init Realm
        mRealm = RealmManager.open();

        //Create a service
        tradeService = RealmManager.createTradeService();

        //Create
        Trade trade = new Trade();
                trade.setId("271728");
                trade.setPrice(1020);
        tradeService.save(trade);

        //Search
        Trade trade1 = (Trade) tradeService.findTradeById("271729");

        //Remove
        tradeService.remove(trade1);


        RealmResults<Trade> trades = tradeService.loadAllAsync();
        Log.d("Thienn" , trades.toString());

//        mRealm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                Item item = realm.createObject(Item.class);
//                item.setName("Fido");
//            }
//        });
//
//        mRealm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                Trade trade = realm.createObject(Trade.class);
//                trade.setId("271729");
//                trade.setPrice(1020);
//
//                Updates update = realm.createObject(Updates.class);
//                update.setKey("190");
//                update.setValue(trade);
//            }
//        });
//
//
//        RealmResults<Item> items = mRealm.where(Item.class).findAll();
//        Log.d("Thienn" , items.toString());
//
//        RealmResults<Updates> updates = mRealm.where(Updates.class).findAll();
//        Log.d("Thienn" , updates.toString());
//
//
//        Log.d("Thienn", "path: " + mRealm.getPath());

    }

    private void initData() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("BUU", "signInAnonymously:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("BUU", "signInAnonymously", task.getException());
                            Toast.makeText(MainActivity.this, "gi do vkl", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


    private void initUI() {
        tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
//        bottomNavigation.setColored(true);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                viewPager.setCurrentItem(position, true);
                return true;
            }
        });
        adapter = new HomePageAdapter(getSupportFragmentManager(),getBaseContext());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                view.setTranslationX(view.getWidth() * -position);

                if(position <= -1.0F || position >= 1.0F) {
                    view.setAlpha(0.0F);
                } else if( position == 0.0F ) {
                    view.setAlpha(1.0F);
                } else {
                    // position is between -1.0F & 0.0F OR 0.0F & 1.0F
                    view.setAlpha(1.0F - Math.abs(position));
                }
            }
        });
        bottomNavigation.setCurrentItem(1);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RealmManager.close();
    }
}
