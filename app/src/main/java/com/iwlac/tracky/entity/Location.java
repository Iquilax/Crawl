package com.iwlac.tracky.entity;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Thien on 4/2/2017.
 */

public class Location extends RealmObject {


    @PrimaryKey
    private String locationId;
    private String name;

    public Location() {
    }

    public Location(String locationId, String name) {
        this.locationId = locationId;
        this.name = name;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                ", locationId='" + locationId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
