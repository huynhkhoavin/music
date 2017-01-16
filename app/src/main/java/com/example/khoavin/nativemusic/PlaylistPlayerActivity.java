package com.example.khoavin.nativemusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.SongCollectionSource;

public class PlaylistPlayerActivity extends AppCompatActivity {

    ListView listSongs;

    ImageView playlistImage;
    TextView listenerCount;
    TextView currentPlay;

    SimpleSong[] songSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        songSource = SongCollectionSource;

        setContentView(R.layout.activity_playlist_player);
        listSongs = (ListView)findViewById(R.id.playlist_list_song);

        playlistImage = (ImageView)findViewById(R.id.grid_image);
        currentPlay = (TextView)findViewById(R.id.playlist_current_play);
        listenerCount = (TextView)findViewById(R.id.playlist_listener_count);

        if(songSource.length != 0)
        {
            listenerCount.setText(FormatListenerCount(songSource[0].getListenerCount()));
            currentPlay.setText(songSource[0].getName());
        }

        ListSongAdapter adapter = new ListSongAdapter(getBaseContext(), songSource);
        listSongs.setAdapter(adapter);
        listSongs.deferNotifyDataSetChanged();

//        listSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                try
//                {
//                    SimpleSong item = (SimpleSong)parent.getItemAtPosition(position);
//
//                    if(item != null)
//                    {
//                        listenerCount.setText(FormatListenerCount(item.getListenerCount()));
//                        currentPlay.setText(item.getName());
//                    }
//                }catch (Exception e)
//                {
//                    System.out.print("##########################################");
//                    System.out.print("Khong the nhan duoc item dang click cho playlist");
//                    System.out.print("##########################################");
//                }
//            }
//        });
    }
}
