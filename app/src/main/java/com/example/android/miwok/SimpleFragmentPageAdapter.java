package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Hisham on 2/11/2018.
 */

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "NUMBERS", "FAMILY", "COLORS" , "PHRASES" };
    private Context context;

    public SimpleFragmentPageAdapter(FragmentManager fm ,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new NumbersFragment();
        else if (position ==1)
            return new FamilyFragment();
        else if (position ==2)
            return new ColorsFragment();
        else
            return new PhrasesFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
