package com.example.khoavin.nativemusic.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khoavin.nativemusic.R;

/**
 * Created by KhoaVin on 13/12/2016.
 */

public class SingerTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.singer_fragment,container,false);
    }

}