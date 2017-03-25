package com.iwlac.tracky.firebasemanager.backgroundservice;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Thien on 3/25/2017.
 */

public class TrackyRSPullService extends IntentService {


    public TrackyRSPullService() {
        super("TrackyRSPullService");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TrackyRSPullService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String dataString = intent.getDataString();

    }
}
