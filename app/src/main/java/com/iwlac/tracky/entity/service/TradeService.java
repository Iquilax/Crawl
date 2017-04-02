package com.iwlac.tracky.entity.service;

import android.support.annotation.NonNull;

import com.iwlac.tracky.entity.Trade;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Thien on 4/2/2017.
 */

public class TradeService {

    private Realm mRealm;

    public TradeService(@NonNull Realm realm) {
        mRealm = realm;
    }

    public void save(final Trade trade) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(trade);
            }
        });
    }

    public void save(final List<Trade> tradeList) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(tradeList);
            }
        });
    }

    public RealmResults<Trade> loadAll() {
        return mRealm.where(Trade.class).findAllSorted("id");
    }

    public RealmResults<Trade> loadAllAsync() {
        return mRealm.where(Trade.class).findAllSortedAsync("id");
    }

    public RealmObject findTradeById(String id) {
        return mRealm.where(Trade.class).equalTo("id", id).findFirst();
    }

    public void remove(@NonNull final RealmObject object) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                object.deleteFromRealm();
            }
        });
    }

    public void removeAll() {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.delete(Trade.class);
            }
        });
    }

    public long count() {
        return mRealm.where(Trade.class).count();
    }
}
