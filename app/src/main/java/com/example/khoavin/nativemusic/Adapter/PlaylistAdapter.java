package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.R;

import java.util.List;

/**
 * Created by KhoaVin on 12/01/2017.
 */

public class PlaylistAdapter extends BaseAdapter {
    Context context;
    SmallPlaylistAdapter[] smallPlaylistAdapters;
    int[] Images;
    public void PlaylistAdapter(Context context,SmallPlaylistAdapter[] listPlaylist, int[] images){
        this.context = context;
        this.smallPlaylistAdapters = listPlaylist;
        this.Images = images;
    }
    @Override
    public int getCount() {
        return this.Images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView;
        listView = convertView;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.single_playlist,null);
            ImageView imageView = (ImageView)listView.findViewById(R.id.playlist_image);
            ListView list = (ListView)listView.findViewById(R.id.small_list);
            imageView.setImageResource(Images[position]);
            list.setAdapter(smallPlaylistAdapters[position]);
        }
        else{
            listView = (View)convertView;
        }
        return listView;
    }
}
