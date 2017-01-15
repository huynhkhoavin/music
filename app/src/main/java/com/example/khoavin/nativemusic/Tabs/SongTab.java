package com.example.khoavin.nativemusic.Tabs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.BottomSheetAdapter;
import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.DataObject.KindOfMusic;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;
import com.example.khoavin.nativemusic.MainActivity;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.MusicKindCollectionSource;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.SongCollectionSource;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class SongTab extends Fragment {
    ListView listView;
    SimpleSong[] collectionSource;

    KindOfMusic[] musicKindSource;
    GridView gridView;
    Button showFilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_fragment,container,false);

        //region GRIDVIEW
        collectionSource = SongCollectionSource;
        ListSongAdapter adapter = new ListSongAdapter(getActivity().getBaseContext(),collectionSource);
        listView = (ListView)view.findViewById(R.id.song_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ((MainActivity)getActivity()).slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });
//        listTopic = (ListView) view.findViewById(R.id.horizontal_listview);
        //endregion

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
