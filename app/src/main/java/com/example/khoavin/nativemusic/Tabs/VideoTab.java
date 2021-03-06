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
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.support.v8.renderscript.*;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.BottomSheetAdapter;
import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.Adapter.ListVideoAdapter;
import com.example.khoavin.nativemusic.DataObject.KindOfMusic;
import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.MainActivity;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;
import com.example.khoavin.nativemusic.VideoPlayerActivity;

import static android.view.View.VISIBLE;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.MusicKindCollectionSource;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.VideoCollectionSource;

/**
 * Created by OatOal on 12/1/2016.
 */

public class VideoTab extends Fragment {
    ListView listView;
    Video[] videoSource;

    KindOfMusic[] musicKindSource;
    GridView gridView;
    Button showFilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment,container,false);

        listView = (ListView) view.findViewById(R.id.video_list_view_parent);

        videoSource = VideoCollectionSource;
        ListVideoAdapter adapter = new ListVideoAdapter(getActivity().getBaseContext(), videoSource);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Video item = (Video) parent.getItemAtPosition(position);

                if(item != null)
                {
                    Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
                    intent.putExtra("VIDEO_NAME", item.GetName());
                    intent.putExtra("VIDEO_IMAGE", item.GetVideoImage());
                    intent.putExtra("VIDEO_LISTENER_COUNT", item.GetListenerCount());
                    intent.putExtra("VIDEO_SINGER", item.GetSinger());

                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getContext(), "No item found!", Toast.LENGTH_LONG);
                }
            }
        });

        //Bottom sheet view
        showFilter = (Button) view.findViewById(R.id.button_loc);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.getContext());
        View bottomSheetView = inflater.inflate(R.layout.bottom_sheet_layout, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        gridView = (GridView)bottomSheetView.findViewById(R.id.grid_music_type);
        musicKindSource = MusicKindCollectionSource;
        BottomSheetAdapter musicKindAdapter = new BottomSheetAdapter(getActivity().getBaseContext(), musicKindSource);
        gridView.setAdapter(musicKindAdapter);

        showFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });

        LinearLayout closeButton = (LinearLayout) bottomSheetDialog.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                KindOfMusic item = (KindOfMusic) parent.getItemAtPosition(position);
                showFilter.setText(item.getName());
                bottomSheetDialog.dismiss();
            }
        });

        return view;
    }

}
