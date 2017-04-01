package com.iwlac.tracky.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Thien on 4/1/2017.
 */

public class Trade extends RealmObject{

    String trackedPlaces;
    String url;
    double price;
    String description;
    String lastUpdate;
    String fullPicture;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFullPicture() {
        return fullPicture;
    }

    public void setFullPicture(String fullPicture) {
        this.fullPicture = fullPicture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "trackedPlaces='" + trackedPlaces + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", fullPicture='" + fullPicture + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
