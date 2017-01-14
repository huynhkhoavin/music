package com.example.khoavin.nativemusic;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.Adapter.ListVideoSmallAdapter;
import com.example.khoavin.nativemusic.DataObject.Video;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.VideoCollectionSource;

public class VideoPlayerActivity extends AppCompatActivity {

    ListView mSmallVideoListView;

    ImageView videoImage;
    TextView listenerCount;
    TextView videoName;

    Video[] videoSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video_player);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mSmallVideoListView = (ListView)findViewById(R.id.video_list_view_small);

        videoImage = (ImageView)findViewById(R.id.video_image);
        videoName = (TextView)findViewById(R.id.video_name);
        listenerCount = (TextView)findViewById(R.id.video_listener_count);

        Bundle extras = getIntent().getExtras();
        if(extras == null)
        {
            videoImage.setImageResource(R.drawable.nhac_dan_ca);
            videoName.setText("Unknow");
            listenerCount.setText("0");
        }
        else
        {
            videoImage.setImageResource(extras.getInt("VIDEO_IMAGE"));
            videoName.setText(extras.getString("VIDEO_NAME"));
            listenerCount.setText(FormatListenerCount(extras.getLong("VIDEO_LISTENER_COUNT")));

            /*extras.getString("VIDEO_NAME");
            extras.getInt("VIDEO_IMAGE");
            extras.getLong("VIDEO_LISTENER_COUNT");
            extras.getString("VIDEO_SINGER");*/
        }


        videoSource = VideoCollectionSource;
        ListVideoSmallAdapter adapter = new ListVideoSmallAdapter(getBaseContext(), videoSource);
        mSmallVideoListView.setAdapter(adapter);
        mSmallVideoListView.deferNotifyDataSetChanged();

        mSmallVideoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Video item = (Video) parent.getItemAtPosition(position);

                videoImage.setImageResource(item.GetVideoImage());
                videoName.setText(item.GetName());
                listenerCount.setText(FormatListenerCount(item.GetListenerCount()));
            }
        });
    }
}
