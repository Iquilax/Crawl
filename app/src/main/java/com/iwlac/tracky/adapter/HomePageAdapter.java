package com.iwlac.tracky.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iwlac.tracky.fragment.BrowseProductFragment;
import com.iwlac.tracky.fragment.HotProductFragment;
import com.iwlac.tracky.fragment.TrackedProductFragment;

/**
 * Created by buupv on 3/22/17.
 */

public class HomePageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private Context context;

    public HomePageAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HotProductFragment.newInstance();
            case 1:
                return HotProductFragment.newInstance();
            case 2:
                return BrowseProductFragment.newInstance();
            default:
                return BrowseProductFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}
