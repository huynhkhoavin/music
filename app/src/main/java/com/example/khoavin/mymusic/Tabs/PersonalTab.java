package com.example.khoavin.mymusic.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khoavin.mymusic.R;

/**
 * Created by KhoaVin on 14/12/2016.
 */

public class PersonalTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.personal_fragment,container,false);
    }

}