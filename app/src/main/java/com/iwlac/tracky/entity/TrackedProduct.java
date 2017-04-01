package com.iwlac.tracky.entity;

import com.iwlac.tracky.models.Trade;

import java.util.HashMap;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Thien on 4/1/2017.
 */

public class TrackedProduct extends RealmObject {

    String id;
    String title ;
    List<String> tags ;
    List<TrackedAttempt> trackedAttempses ;
    public HashMap<String,Trade> updates;
}
