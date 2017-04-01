package com.iwlac.tracky.entity;

import io.realm.RealmObject;

/**
 * Created by Thien on 4/1/2017.
 */

public class TrackedPlace extends RealmObject {
    private String attemptId;
    private String place;

    public TrackedPlace() {
    }

    public String getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(String attemptId) {
        this.attemptId = attemptId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "TrackedPlace{" +
                "attemptId='" + attemptId + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
