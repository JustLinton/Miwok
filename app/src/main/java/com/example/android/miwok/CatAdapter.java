/*
 * Copyright (c) 2020. JM Jiang or LintonC of berrySDU.com.
 */

package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CatAdapter extends FragmentPagerAdapter {
    public CatAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NumberFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorFragment();
            case 3:
                return new PhraseFragment();
        }
        return new NumberFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Numbers";
            case 1:
                return "Family";
            case 2:
                return "Colors";
            case 3:
                return "Phrases";
            default:
                return "0";

        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
