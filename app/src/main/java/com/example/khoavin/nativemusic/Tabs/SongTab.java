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
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class SongTab extends Fragment {
    ListView listView;
    String[] songNames = {
            "Google",
            "Github",
            "Instagram",
            "Facebook",
            "Flickr",
            "Pinterest",
            "Quora",
            "Twitter",
            "Vimeo",
            "WordPress",
            "Youtube",
            "Stumbleupon",
            "SoundCloud",
            "Reddit",
            "Blogger"

    } ;
    int[] songImage = {
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female,
            R.drawable.model_female
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_fragment,container,false);

        //region GRIDVIEW
        ListSongAdapter adapter = new ListSongAdapter(getActivity().getBaseContext(),songNames,songImage);
        listView = (ListView)view.findViewById(R.id.song_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +songNames[+ position], Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(getActivity(),view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(),"Popup : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();//showing popup menu
            }
        });
        listView = (ListView) view.findViewById(R.id.horizontal_listview);
        //endregion
        return view;
    }
}
