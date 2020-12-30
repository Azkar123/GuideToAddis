package com.guidetoaddis;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.resources.CancelableFontCallback;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                UpcomingFragment upcomingFragment = new UpcomingFragment();
                return upcomingFragment;
            case 1:
                CompletedFragment completedFragment = new CompletedFragment();
                return completedFragment;
            case 2:
                CancelledFragment cancelledFragment = new CancelledFragment();
                return cancelledFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;

    }
}
