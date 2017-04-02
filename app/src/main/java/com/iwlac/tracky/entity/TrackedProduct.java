package com.iwlac.tracky.entity;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Thien on 4/1/2017.
 */

public class TrackedProduct extends RealmObject {

    String id;
    String title ;
    RealmList<Tag> tags ;
    RealmList<TrackedAttempt> trackedAttempts ;
    RealmList<Updates> updates;

    public TrackedProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RealmList<Tag> getTags() {
        return tags;
    }

    public void setTags(RealmList<Tag> tags) {
        this.tags = tags;
    }

    public RealmList<TrackedAttempt> getTrackedAttempts() {
        return trackedAttempts;
    }

    public void setTrackedAttempts(RealmList<TrackedAttempt> trackedAttempts) {
        this.trackedAttempts = trackedAttempts;
    }

    public RealmList<Updates> getUpdates() {
        return updates;
    }

    public void setUpdates(RealmList<Updates> updates) {
        this.updates = updates;
    }

    @Override
    public String toString() {
        return "TrackedProduct{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tags=" + tags +
                ", trackedAttempts=" + trackedAttempts +
                ", updates=" + updates +
                '}';
    }
}
