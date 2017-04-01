package com.iwlac.tracky.entity;

import io.realm.RealmObject;

/**
 * Created by Thien on 4/1/2017.
 */

public class Tag extends RealmObject {
    private String productId;
    private String tag;

    public Tag() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
                "productId='" + productId + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
