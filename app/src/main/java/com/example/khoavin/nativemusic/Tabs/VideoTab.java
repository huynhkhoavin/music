package com.example.khoavin.nativemusic.Tabs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.support.v8.renderscript.*;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.Adapter.ListVideoAdapter;
import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.MainActivity;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;
import com.example.khoavin.nativemusic.VideoPlayerActivity;

import static android.view.View.VISIBLE;

/**
 * Created by OatOal on 12/1/2016.
 */

public class VideoTab extends Fragment {
    ListView listView;

    Video[] videoSource = {
            //new Video("Lạc trôi", "Sơn Tùng MTP", "", 999000, R.drawable.background),
            //new Video("Em của ngày hôm qua", "Sơn Tùng MTP", "", 725000, R.drawable.background),
            new Video("Cơn mưa ngang qua", "Sơn Tùng MTP", "", 152000, R.drawable.model_female),
            new Video("Dấu mưa", "Trung Quân Idol", "", 65000, R.drawable.nhac_dan_ca),
            new Video("Sai càng sai", "Chi Dân", "", 32000, R.drawable.model_female),
            new Video("Duyên nghèo", "Mạnh Quỳnh - Phi Nhung", "", 44000, R.drawable.nhac_dan_ca),
            new Video("Ru lại câu hò", "Cẩm Ly", "", 350000, R.drawable.model_female),
            new Video("Căn nhà màu tím", "Mạnh Quỳnh - Phi Nhung", "", 116000, R.drawable.background),
            new Video("Áo hoa", "Quang Lê - Mai Thiên Vân", "", 83000, R.drawable.model_female),
            new Video("Chuyện tình Lan và Điệp", "Tui Chịu", "", 74000, R.drawable.nhac_dan_ca),
            new Video("Khúc thụy du", "Khánh Ly", "", 999, R.drawable.model_female),
            new Video("Xuân tha hương lạc xứ", "Trường Vũ", "", 325, R.drawable.background)
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment,container,false);

        listView = (ListView) view.findViewById(R.id.video_list_view_parent);

        ListVideoAdapter adapter = new ListVideoAdapter(getActivity().getBaseContext(), videoSource);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra("NewIntentMessage", "this is a test message!");
                startActivity(intent);
            }
        });

        return view;
    }

}
