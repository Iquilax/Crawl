package com.iwlac.tracky.activity;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
        initData();

        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfig);

        mRealm = Realm.getInstance(realmConfig);

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Item item = realm.createObject(Item.class);
                item.setName("Fido");
            }
        });


        RealmResults<Item> items = mRealm.where(Item.class).findAll();
        System.out.println("Thienn" + items);




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
        bottomNavigation.setCurrentItem(1);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
