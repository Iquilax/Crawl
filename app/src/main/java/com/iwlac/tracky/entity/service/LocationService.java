package com.iwlac.tracky.entity.service;

/**
 * Created by Thien on 4/2/2017.
 */

import android.support.annotation.NonNull;

import com.iwlac.tracky.entity.Location;
import com.iwlac.tracky.entity.Trade;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

import android.support.annotation.NonNull;

import com.iwlac.tracky.entity.Trade;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Thien on 4/2/2017.
 */

public class LocationService {

    private Realm mRealm;

    public LocationService(@NonNull Realm realm) {
        mRealm = realm;
    }

    public void save(final Location location) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(location);
            }
        });
    }

    public void save(final List<Location> locationList) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(locationList);
            }
        });
    }

    public RealmResults<Location> loadAll() {
        return mRealm.where(Location.class).findAll();
    }

    public RealmResults<Location> loadAllAsync() {
        return mRealm.where(Location.class).findAllAsync();
    }

    public RealmObject findLocationById(String id) {
        return mRealm.where(Location.class).equalTo("locationId", id).findFirst();
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
                mRealm.delete(Location.class);
            }
        });
    }

    public long count() {
        return mRealm.where(Location.class).count();
    }
}
