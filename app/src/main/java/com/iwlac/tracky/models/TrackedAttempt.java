package com.iwlac.tracky.models;

import java.util.List;

/**
 * Created by buupv on 3/27/17.
 */

public class TrackedAttempt {
    String id;
    double price;
    List<String> trackedPlaces;

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
}
