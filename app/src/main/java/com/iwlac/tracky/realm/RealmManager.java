package com.iwlac.tracky.realm;

import com.iwlac.tracky.entity.Trade;
import com.iwlac.tracky.entity.service.LocationService;
import com.iwlac.tracky.entity.service.TrackedAttemptService;
import com.iwlac.tracky.entity.service.TradeService;

import io.realm.Realm;

/**
 * Created by Thien on 4/2/2017.
 */

public class RealmManager {

    private static Realm mRealm;

    public static Realm open() {
        mRealm = Realm.getDefaultInstance();
        return mRealm;
    }

    public static void close() {
        if (mRealm != null) {
            mRealm.close();
        }
    }

    public static TrackedAttemptService createTrackedAttemptService() {
        checkForOpenRealm();
        return new TrackedAttemptService(mRealm);
    }

    public static TradeService createTradeService() {
        checkForOpenRealm();
        return new TradeService(mRealm);
    }

    public static LocationService createLocationService() {
        checkForOpenRealm();
        return new LocationService(mRealm);
    }

    public static void clear() {
        checkForOpenRealm();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Trade.class);
            }
        });
    }

    private static void checkForOpenRealm() {
        if (mRealm == null || mRealm.isClosed()) {
            mRealm = RealmManager.open();
            //throw new IllegalStateException("RealmManager: Realm is closed, call open() method first");
        }
    }
}