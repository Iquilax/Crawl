package com.iwlac.tracky.entity;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Thien on 4/1/2017.
 */

public class Item extends RealmObject {
    @Required
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
