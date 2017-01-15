package com.example.khoavin.nativemusic.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.khoavin.nativemusic.Adapter.SingerAdapter;
import com.example.khoavin.nativemusic.DataObject.Artist;
import com.example.khoavin.nativemusic.PlaylistPlayerActivity;
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

                Intent intent = new Intent(getActivity(), PlaylistPlayerActivity.class);
                intent.putExtra("PLAYLIST_IMAGE", R.drawable.nhac_dan_ca_2);
                intent.putExtra("PLAYLIST_LISTENER_COUNT", 1215462);
                startActivity(intent);
            }
        });

        return view;
    }

}