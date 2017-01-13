package com.example.khoavin.nativemusic.Tabs;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.khoavin.nativemusic.Adapter.SmallPlaylistAdapter;
import com.example.khoavin.nativemusic.Fragment.DetailFragment;
import com.example.khoavin.nativemusic.R;

import static android.support.v7.appcompat.R.styleable.ActionBar;

/**
 * Created by KhoaVin on 13/12/2016.
 */

public class RankTab extends Fragment {
    ActionBar actionbar;
    int[] Sequences = {1,2,3,4};
    String[] SongNames = {"Lạc Trôi", "Đi Về Đâu","Lạc Nhau Có Phải Muôn Đời", "Phía Sau Một Cô Gái"};
    String[] Singers = {"Sơn Tùng M-TP", "Tiên Tiên", "Errik ST.319", "Soobin Hoàng Sơn"};
    String[] HearNumber = {"13k","5k","4.3k","4.1k"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rank_fragment,container,false);

        SmallPlaylistAdapter smallPlaylistAdapter = new SmallPlaylistAdapter(this.getActivity().getBaseContext(),Sequences,SongNames,Singers,HearNumber);

        return view;
    }

}