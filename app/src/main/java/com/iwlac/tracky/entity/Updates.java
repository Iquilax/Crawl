package com.iwlac.tracky.entity;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Thien on 4/1/2017.
 */

public class Updates extends RealmObject {
    private String key;
    private Trade value;

    public Updates() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Trade getValue() {
        return value;
    }

    public void setValue(Trade value) {
        this.value = value;
    }
}
