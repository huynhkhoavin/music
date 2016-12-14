package com.example.khoavin.mymusic.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.khoavin.mymusic.Tabs.*;

/**
 * Created by KhoaVin on 14/12/2016.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new HomeTab();
            case 1:
                return new SearchTab();
            case 2:
                return new FavouriteTab();
            case 3:
                return new PersonalTab();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 4;
    }
}
