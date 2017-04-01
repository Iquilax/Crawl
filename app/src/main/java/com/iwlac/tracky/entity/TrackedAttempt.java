package com.iwlac.tracky.entity;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Thien on 4/1/2017.
 */

public class TrackedAttempt extends RealmObject {

    @Required
    String id;
    @Required
    double price;
    @Required
    List<String> trackedPlaces;

    public TrackedAttempt(String id, double price, List<String> trackedPlaces) {
        this.id = id;
        this.price = price;
        this.trackedPlaces = trackedPlaces;
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

    public List<String> getTrackedPlaces() {
        return trackedPlaces;
    }

    public void setTrackedPlaces(List<String> trackedPlaces) {
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
