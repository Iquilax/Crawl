package com.iwlac.tracky.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import org.parceler.Parcel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by buupv on 3/25/17.
 */

public class TrackedProduct{

    String id;
    String title ;
    List<String> tags ;
    List<TrackedAttempt> trackedAttempses ;
    public HashMap<String,Trade> updates;

    public TrackedProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TrackedAttempt> getTrackedAttempses() {
        return trackedAttempses;
    }

    public void setTrackedAttempses(List<TrackedAttempt> trackedAttempses) {
        this.trackedAttempses = trackedAttempses;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public HashMap<String, Trade> getUpdates() {
        return updates;
    }

    public void getCheapest(){

    }

    public void setUpdates(HashMap<String, Trade> updates) {
        this.updates = updates;
    }


}
