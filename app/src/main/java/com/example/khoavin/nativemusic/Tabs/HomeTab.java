package com.example.khoavin.nativemusic.Tabs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.Adapter.NormalPlayListAdapter;
import com.example.khoavin.nativemusic.Adapter.TopicAdapter;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;
import com.example.khoavin.nativemusic.DataObject.Topic;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.PlaylistCollectionSource;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.SongCollectionSource;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.TopicCollectionSource;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class HomeTab extends Fragment {
    GridView grid;
    GridView grid2;
    ListView listTopic;
    ListView listSong;
    NormalPlayList[] dataSource;
    SimpleSong[] collectionSource;
    Topic[] topicSource;
    int[] listImage = {
            R.drawable.duong_ngoc_thai,
            R.drawable.quang_dung,
            R.drawable.quang_le,
            R.drawable.lactroi_music,
            R.drawable.duong_ngoc_thai,
            R.drawable.quang_dung,
            R.drawable.quang_le,
            R.drawable.lactroi_music,
            R.drawable.lactroi_music
    };
    String[] listSongName = {"Éo Le Cuộc Tình","Anh Còn Nợ Em", "Xuân Này Con Không Về","Cơn Mưa Ngang Qua","Éo Le Cuộc Tình","Anh Còn Nợ Em", "Xuân Này Con Không Về","Cơn Mưa Ngang Qua","Cơn Mưa Ngang Qua"};
    String[] listSingerName = {"Dương Ngọc Thái", "Quang Dũng", "Quang Lê", "Sơn Tùng M-TP","Dương Ngọc Thái", "Quang Dũng", "Quang Lê", "Sơn Tùng M-TP","Sơn Tùng M-TP"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        //ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.white);
        Bitmap blurBitmap = BlurBuilder.blur(bitmap,this.getContext());
        //view.setBackground(new BitmapDrawable(getResources(), bitmap));

        dataSource = PlaylistCollectionSource;
        topicSource = TopicCollectionSource;
        collectionSource = SongCollectionSource;

        listTopic = (ListView)view.findViewById(R.id.topic_listview);
        TopicAdapter topicAdapter = new TopicAdapter(getActivity().getBaseContext(), topicSource);
        listTopic.setAdapter(topicAdapter);

        listSong = (ListView)view.findViewById(R.id.song_listview);
        ListSongAdapter listSongAdapter = new ListSongAdapter(getActivity().getBaseContext(),collectionSource);
        listSong.setAdapter(listSongAdapter);

        //region GRIDVIEW
        GridViewAdapter adapter = new GridViewAdapter(getActivity().getBaseContext(),listImage,listSongName,listSingerName);
        NormalPlayListAdapter normalPlayListAdapter = new NormalPlayListAdapter(getActivity().getBaseContext(),dataSource);
        grid = (GridView)view.findViewById(R.id.grid_view);
        grid2 = (GridView)view.findViewById(R.id.grid_view2);
        grid.setAdapter(adapter);
        grid2.setAdapter(normalPlayListAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(getActivity(),view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(),"Popup : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();//showing popup menu
            }
        });
        //endregion

        //endregion
        return view;
    }

}
