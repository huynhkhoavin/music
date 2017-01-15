package com.example.khoavin.nativemusic.Tabs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.BottomSheetAdapter;
import com.example.khoavin.nativemusic.Adapter.NormalPlayListAdapter;
import com.example.khoavin.nativemusic.DataObject.KindOfMusic;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.PlaylistPlayerActivity;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;
import com.example.khoavin.nativemusic.VideoPlayerActivity;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.MusicKindCollectionSource;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.PlaylistCollectionSource;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class PlayListTab extends Fragment {

    GridView grid;

    KindOfMusic[] musicKindSource;
    GridView gridView;
    Button showFilter;

    NormalPlayList[] dataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist_fragment,container,false);
        //ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.white);
        Bitmap blurBitmap = BlurBuilder.blur(bitmap,this.getContext());
        //view.setBackground(new BitmapDrawable(getResources(), bitmap));

        //region GRIDVIEW
        dataSource = PlaylistCollectionSource;
        NormalPlayListAdapter adapter = new NormalPlayListAdapter(getActivity().getBaseContext(),dataSource);

        grid = (GridView)view.findViewById(R.id.playlist_gridview);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NormalPlayList item = (NormalPlayList)parent.getItemAtPosition(position);

                if(item != null)
                {
                    Intent intent = new Intent(getActivity(), PlaylistPlayerActivity.class);
                    intent.putExtra("PLAYLIST_IMAGE", item.getPlayListImage());
                    intent.putExtra("PLAYLIST_LISTENER_COUNT", item.getListenerCount());
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
