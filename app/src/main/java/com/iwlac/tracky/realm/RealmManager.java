package com.iwlac.tracky.realm;

import com.iwlac.tracky.entity.Trade;
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

    public static TradeService createTradeService() {
        checkForOpenRealm();
        return new TradeService(mRealm);
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
            throw new IllegalStateException("RealmManager: Realm is closed, call open() method first");
        }
    }
}