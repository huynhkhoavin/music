package com.example.khoavin.nativemusic.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.khoavin.nativemusic.Tabs.*;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new HomeTab();
            case 1: return new PlayListTab();
            case 2: return new SongTab();
            case 3: return new VideoTab();
            case 4: return new RankTab();
            case 5: return new SingerTab();
            case 6: return new TopicTab();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 7;
    }
}
