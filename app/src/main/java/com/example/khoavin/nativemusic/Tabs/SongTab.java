package com.example.khoavin.nativemusic.Tabs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.SongCollectionSource;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class SongTab extends Fragment {
    ListView listView;

    SimpleSong[] collectionSource;

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
                Toast.makeText(getActivity(), "You Clicked at " +collectionSource[+ position].getName(), Toast.LENGTH_SHORT).show();
            }
        });
//        listView = (ListView) view.findViewById(R.id.horizontal_listview);
        //endregion
        return view;
    }
}
