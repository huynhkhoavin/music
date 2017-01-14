package com.example.khoavin.nativemusic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.NormalPlayListAdapter;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.PlaylistCollectionSource;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class TopicDetailsActivity extends AppCompatActivity {

    GridView grid;

    NormalPlayList[] dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_topic_details);

        dataSource = PlaylistCollectionSource;
        NormalPlayListAdapter adapter = new NormalPlayListAdapter(getBaseContext(),dataSource);

        grid = (GridView)findViewById(R.id.topic_playlist);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NormalPlayList item = (NormalPlayList)parent.getItemAtPosition(position);

                if(item != null)
                {
                    Intent intent = new Intent(getBaseContext(), PlaylistPlayerActivity.class);

                    intent.putExtra("PLAYLIST_IMAGE", item.getPlayListImage());
                    intent.putExtra("PLAYLIST_LISTENER_COUNT", item.getListenerCount());
                    startActivity(intent);
                }
                else
                {

                }
            }
        });
    }
}
