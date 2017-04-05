package com.iwlac.tracky.entity.service;

import android.support.annotation.NonNull;

import com.iwlac.tracky.entity.Trade;
import com.iwlac.tracky.models.TrackedAttempt;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Thien on 4/2/2017.
 */

public class TrackedAttemptService {
    private Realm mRealm;

    public TrackedAttemptService(@NonNull Realm realm) {
        mRealm = realm;
    }

    public void save(final com.iwlac.tracky.entity.TrackedAttempt trackedAttempt) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(trackedAttempt);
            }
        });
    }

    public void save(final List<com.iwlac.tracky.entity.TrackedAttempt> trackedAttemptList) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(trackedAttemptList);
            }
        });
    }

    public RealmResults<com.iwlac.tracky.entity.TrackedAttempt> loadAll() {
        return mRealm.where(com.iwlac.tracky.entity.TrackedAttempt.class).findAllSorted("id");
    }

    public RealmResults<com.iwlac.tracky.entity.TrackedAttempt> loadAllAsync() {
        return mRealm.where(com.iwlac.tracky.entity.TrackedAttempt.class).findAllSortedAsync("id");
    }

    public RealmObject findTradeById(String id) {
        return mRealm.where(com.iwlac.tracky.entity.TrackedAttempt.class).equalTo("id", id).findFirst();
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
                mRealm.delete(com.iwlac.tracky.entity.TrackedAttempt.class);
            }
        });
    }

    public long count() {
        return mRealm.where(com.iwlac.tracky.entity.TrackedAttempt.class).count();
    }
}
