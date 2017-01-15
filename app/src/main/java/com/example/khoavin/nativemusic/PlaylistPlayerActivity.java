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

        setContentView(R.layout.activity_playlist_player);
        listSongs = (ListView)findViewById(R.id.playlist_list_song);

        playlistImage = (ImageView)findViewById(R.id.grid_image);
        currentPlay = (TextView)findViewById(R.id.playlist_current_play);
        listenerCount = (TextView)findViewById(R.id.playlist_listener_count);

        Bundle extras = getIntent().getExtras();
        if(extras == null)
        {
            playlistImage.setImageResource(R.drawable.nhac_dan_ca);
            currentPlay.setText("Unknow");
            listenerCount.setText("0");
        }
        else
        {
            playlistImage.setImageResource(extras.getInt("PLAYLIST_IMAGE"));
            listenerCount.setText(FormatListenerCount(extras.getLong("PLAYLIST_LISTENER_COUNT")));
        }


        songSource = SongCollectionSource;
        ListSongAdapter adapter = new ListSongAdapter(getBaseContext(), songSource);
        listSongs.setAdapter(adapter);
        listSongs.deferNotifyDataSetChanged();
    }
}
