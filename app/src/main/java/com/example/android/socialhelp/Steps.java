package com.example.android.socialhelp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by User on 29-06-2017.
 */

public class Steps extends FragmentPagerAdapter {
    public Steps(FragmentManager fm) {
        super(fm);
    }
    private String tabTitles[] = new String[] { "STEP 1", "STEP 2"};
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new StepFragment();
        else
            return new StepFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
