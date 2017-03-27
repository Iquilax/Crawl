package com.iwlac.tracky.models;

import android.os.Parcelable;

import org.parceler.Parcel;

/**
 * Created by buupv on 3/26/17.
 */

@Parcel
public class Trade {
    String trackedPlaces;
    String url;
    double price;
    String lastUpdate;
    String id;

    public Trade() {
    }

    public String getTrackedPlaces() {
        return trackedPlaces;
    }

    public void setTrackedPlaces(String trackedPlaces) {
        this.trackedPlaces = trackedPlaces;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
