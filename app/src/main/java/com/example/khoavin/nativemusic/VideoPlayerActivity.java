package com.example.khoavin.nativemusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.khoavin.nativemusic.Adapter.ListVideoSmallAdapter;
import com.example.khoavin.nativemusic.DataObject.Video;

/**
 * Created by OatOal on 1/12/2017.
 */

public class VideoPlayerActivity extends AppCompatActivity {

    ListView mSmallVideoListView;

    Video[] videoSource = {
            new Video("Chuyện tình Lan và Điệp", "Tui Chịu", "", 74000, R.drawable.nhac_dan_ca),
            new Video("Khúc thụy du", "Khánh Ly", "", 999, R.drawable.model_female),
            new Video("Xuân tha hương lạc xứ", "Trường Vũ", "", 325, R.drawable.background),
            new Video("Cơn mưa ngang qua", "Sơn Tùng MTP", "", 152000, R.drawable.model_female),
            new Video("Dấu mưa", "Trung Quân Idol", "", 65000, R.drawable.nhac_dan_ca),
            new Video("Sai càng sai", "Chi Dân", "", 32000, R.drawable.model_female),
            new Video("Duyên nghèo", "Mạnh Quỳnh - Phi Nhung", "", 44000, R.drawable.nhac_dan_ca)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.video_player_fragment);
        mSmallVideoListView = (ListView)findViewById(R.id.video_list_view_small);

        ListVideoSmallAdapter adapter = new ListVideoSmallAdapter(getBaseContext(), videoSource);
        mSmallVideoListView.setAdapter(adapter);
        mSmallVideoListView.deferNotifyDataSetChanged();
    }
}
