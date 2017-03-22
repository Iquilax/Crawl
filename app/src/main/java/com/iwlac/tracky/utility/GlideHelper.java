package com.iwlac.tracky.utility;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Thien on 3/23/2017.
 */
public class GlideHelper {

    static Context context;
    private static GlideHelper instance;

    public static GlideHelper getInstance(Context context) {
        instance = new GlideHelper(context);
        return instance;
    }

    private GlideHelper(Context context) {
        this.context = context;
    }

    public static void loadImageToView(String url, ImageView view){
        Glide.with(context).load(url).into(view);
    }
}
