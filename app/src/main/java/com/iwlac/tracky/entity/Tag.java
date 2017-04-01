package com.iwlac.tracky.entity;

import io.realm.RealmObject;

/**
 * Created by Thien on 4/1/2017.
 */

public class Tag extends RealmObject {
    private TrackedProduct trackedProduct;
    private String tag;

    public Tag() {
    }


    public Tag(TrackedProduct trackedProduct, String tag) {
        this.trackedProduct = trackedProduct;
        this.tag = tag;
    }

    public TrackedProduct getTrackedProduct() {
        return trackedProduct;
    }

    public void setTrackedProduct(TrackedProduct trackedProduct) {
        this.trackedProduct = trackedProduct;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "trackedProduct=" + trackedProduct +
                ", tag='" + tag + '\'' +
                '}';
    }
}
