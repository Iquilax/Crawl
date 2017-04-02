package com.iwlac.tracky.firebasemanager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iwlac.tracky.models.TrackedAttempt;

import java.util.ArrayList;

/**
 * Created by buupv on 3/26/17.
 */

public class Database {
    static DatabaseReference dbRef;

    public Database() {

    }

    public static DatabaseReference getProduct() {
        dbRef = FirebaseDatabase.getInstance().getReference("products");
        return dbRef;
    }

    public static DatabaseReference getLocation() {
        dbRef = FirebaseDatabase.getInstance().getReference("locations");
        return dbRef;
    }

    public static boolean track(String id, String itemId, double price) {
        TrackedAttempt attempt = new TrackedAttempt();
        attempt.setPrice(price);
        attempt.setId(id);
        attempt.setTrackedPlaces(new ArrayList<String>());
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("products/" + itemId + "/trackedAttempts");
        ref.child(id).setValue(attempt);
        return false;
    }


}
