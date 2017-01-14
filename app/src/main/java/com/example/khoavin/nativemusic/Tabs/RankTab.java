package com.example.khoavin.nativemusic.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.khoavin.nativemusic.Adapter.PlaylistAdapter;
import com.example.khoavin.nativemusic.R;

/**
 * Created by KhoaVin on 13/12/2016.
 */

public class RankTab extends Fragment {
    ActionBar actionbar;
    int[] Sequences = {2,3,4,5,6,7,8,9};
    String[] SongNames = {"Đi Về Đâu","Lạc Nhau Có Phải Muôn Đời", "Phía Sau Một Cô Gái", "Cho Em Gần Anh Thêm Chút Nữa", "Con Tim Tan Vỡ", "Vỡ Tan","Đi Để Trở Về"};;
    String[] Singers = {"Tiên Tiên", "Errik ST.319", "Soobin Hoàng Sơn", "Hương Tràm","Phan Mạnh Quỳnh","Trịnh Thăng Bình","Soobin Hoàng Sơn"};
    long[] HearNumber = {584626,784548,968541784,781418,32654,87664,639656,862447};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rank_fragment,container,false);

        //PlaylistAdapter(Context context, int[] seq, String[] songNames, String[] singers, String[] hearNumber){
        PlaylistAdapter playlistAdapter = new PlaylistAdapter(this.getActivity().getBaseContext(), Sequences,SongNames,Singers,HearNumber);
        ListView listRank = (ListView)view.findViewById(R.id.lv_rank);
        listRank.setAdapter(playlistAdapter);
        return view;
    }

}