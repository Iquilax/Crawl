package com.iwlac.tracky.entity;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Thien on 4/1/2017.
 */

public class TrackedAttempt extends RealmObject {

    String id;
    double price;
    RealmList<TrackedPlace> trackedPlaces;

    public TrackedAttempt() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RealmList<TrackedPlace> getTrackedPlaces() {
        return trackedPlaces;
    }

    public void setTrackedPlaces(RealmList<TrackedPlace> trackedPlaces) {
        this.trackedPlaces = trackedPlaces;
    }

    @Override
    public String toString() {
        return "TrackedAttempt{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", trackedPlaces=" + trackedPlaces +
                '}';
    }
}
