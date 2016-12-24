package com.example.khoavin.nativemusic.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khoavin.nativemusic.R;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class SongTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.song_fragment,container,false);
    }
}
