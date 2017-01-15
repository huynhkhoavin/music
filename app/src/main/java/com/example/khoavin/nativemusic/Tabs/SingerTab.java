package com.example.khoavin.nativemusic.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.khoavin.nativemusic.Adapter.SingerAdapter;
import com.example.khoavin.nativemusic.DataObject.Artist;
import com.example.khoavin.nativemusic.R;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.ArtistCollectionSource;

/**
 * Created by OatOal on 13/12/2016.
 */

public class SingerTab extends Fragment {
    GridView gridArtist;
    Artist[] artistSource;

//    KindOfMusic[] musicKindSource;
//    GridView gridView;
//    Button showFilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.singer_fragment,container,false);

        gridArtist = (GridView) view.findViewById(R.id.grid_artist);

        artistSource = ArtistCollectionSource;
        SingerAdapter adapter = new SingerAdapter(getActivity().getBaseContext(), artistSource);
        gridArtist.setAdapter(adapter);

        gridArtist.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist item = (Artist) parent.getItemAtPosition(position);
            }
        });

//        //Bottom sheet view
//        showFilter = (Button) view.findViewById(R.id.button_loc);
//        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.getContext());
//        View bottomSheetView = inflater.inflate(R.layout.bottom_sheet_layout, null);
//        bottomSheetDialog.setContentView(bottomSheetView);
//
//        gridView = (GridView)bottomSheetView.findViewById(R.id.grid_music_type);
//        musicKindSource = MusicKindCollectionSource;
//        BottomSheetAdapter musicKindAdapter = new BottomSheetAdapter(getActivity().getBaseContext(), musicKindSource);
//        gridView.setAdapter(musicKindAdapter);
//
//        showFilter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomSheetDialog.show();
//            }
//        });
//
//        LinearLayout closeButton = (LinearLayout) bottomSheetDialog.findViewById(R.id.close_button);
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                bottomSheetDialog.dismiss();
//            }
//        });
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                KindOfMusic item = (KindOfMusic) parent.getItemAtPosition(position);
//                showFilter.setText(item.getName());
//                bottomSheetDialog.dismiss();
//            }
//        });

        return view;
    }

}