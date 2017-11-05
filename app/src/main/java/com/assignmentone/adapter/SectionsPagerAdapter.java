package com.assignmentone.adapter;

/**
 * Created by prashant.mudgal on 11/1/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.assignmentone.fragments.FragmentFour;
import com.assignmentone.fragments.FragmentOne;
import com.assignmentone.fragments.FragmentThree;
import com.assignmentone.fragments.FragmentTwo;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            case 3:
                return new FragmentFour();
            default:
                return new FragmentOne();
        }

    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}