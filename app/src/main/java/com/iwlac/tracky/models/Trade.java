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
    String description;
    String lastUpdate;
    String fullPicture;
    String id;
    String trackPlaceName;

    public Trade() {
    }

    public String getFullPicture() {
        return fullPicture;
    }

    public void setFullPicture(String fullPicture) {
        this.fullPicture = fullPicture;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTrackPlaceName() {
        return trackPlaceName;
    }

    public void setTrackPlaceName(String trackPlaceName) {
        this.trackPlaceName = trackPlaceName;
    }
}
