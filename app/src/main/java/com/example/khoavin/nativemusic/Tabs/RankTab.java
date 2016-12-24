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

import com.example.khoavin.nativemusic.Fragment.DetailFragment;
import com.example.khoavin.nativemusic.R;

import static android.support.v7.appcompat.R.styleable.ActionBar;

/**
 * Created by KhoaVin on 13/12/2016.
 */

public class RankTab extends Fragment {
    ActionBar actionbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rank_fragment,container,false);
        Button btnChange = (Button)view.findViewById(R.id.btn_change_fragment);
        btnChange.setOnClickListener(onChangeFragment());
        return view;
    }

    private View.OnClickListener onChangeFragment() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailFragment fragment  = new DetailFragment();
                //actionbar.hide();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout,fragment);
                fragmentTransaction.commit();
            }
        };
    }
}