package com.iwlac.tracky.manager.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Thien on 3/28/2017.
 */



public class TrackySharedPreferencesManager {

    private static final String UNREAD_NOTIFICATION_PREF = "com.iwlac.tracky.manager.sharedpreference.UNREAD_NOTIFICATION_PREF";
    private static final String UNREAD_NOTIFICATION_COUNT = "com.iwlac.tracky.manager.sharedpreference.UNREAD_NOTIFICATION_COUNT";

    private static TrackySharedPreferencesManager sInstance;
    private final SharedPreferences mPref;

    private TrackySharedPreferencesManager(Context context) {
        mPref = context.getSharedPreferences(UNREAD_NOTIFICATION_PREF, Context.BIND_EXTERNAL_SERVICE);
    }

    public static synchronized TrackySharedPreferencesManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TrackySharedPreferencesManager(context);
        }
        return sInstance;
    }

    public void setUnreadNotificationCount(int value) {
        mPref.edit()
                .putInt(UNREAD_NOTIFICATION_COUNT, value)
                .commit();
    }

    public int getUnreadNotificationCount() {
        return mPref.getInt(UNREAD_NOTIFICATION_COUNT, 0);
    }

    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}