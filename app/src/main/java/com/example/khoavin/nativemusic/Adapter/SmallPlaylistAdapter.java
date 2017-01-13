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

/**
 * Created by KhoaVin on 12/01/2017.
 */

public class SmallPlaylistAdapter extends BaseAdapter {
    Context context;
    int[] sequences;
    int[] backgrounds;
    String[] songNames;
    String[] singers;
    String[] hearNumbers;
    public SmallPlaylistAdapter(Context context, int[] seq, String[] songNames, String[] singers, String[] hearNumber){
        this.context = context;
        this.sequences = seq;
        this.songNames = songNames;
        this.singers = singers;
        this.hearNumbers = hearNumber;
    }
    @Override
    public int getCount() {
        return 0;
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
            listView = inflater.inflate(R.layout.single_small_list,null);
            TextView sequenceNumber = (TextView)listView.findViewById(R.id.small_list_image);
            TextView songName = (TextView)listView.findViewById(R.id.small_list_songname);
            TextView singer = (TextView)listView.findViewById(R.id.small_list_singer);
            TextView hearNumber = (TextView)listView.findViewById(R.id.small_list_hearnumber);

            sequenceNumber.setText(sequences[position]);
            songName.setText(songNames[position]);
            singer.setText(singers[position]);
            hearNumber.setText(hearNumbers[position]);
        }
        else{
            listView = (View)convertView;
        }
        return listView;
    }
}
