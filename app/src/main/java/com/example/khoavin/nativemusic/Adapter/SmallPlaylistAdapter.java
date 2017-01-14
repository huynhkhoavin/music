package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
        return songNames.length;
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

        ViewHolder holder = null;

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.single_small_list,null);

            holder = new ViewHolder();
            holder.sequenceNumber = (TextView)listView.findViewById(R.id.small_list_tv);
            holder.songName = (TextView)listView.findViewById(R.id.small_list_songname);
            holder.singer = (TextView)listView.findViewById(R.id.small_list_singer);
            holder.hearNumber = (TextView)listView.findViewById(R.id.small_list_hearnumber);

            listView.setTag(holder);
        }
        else{
            holder = (ViewHolder)listView.getTag();
        }

        holder.sequenceNumber.setText(String.valueOf(sequences[position]));
        holder.songName.setText(songNames[position]);
        holder.singer.setText(singers[position]);
        holder.hearNumber.setText(hearNumbers[position]);

        return listView;
    }

    private class ViewHolder
    {
        public TextView sequenceNumber;
        public TextView songName;
        public TextView singer;
        public TextView hearNumber;
    }
}
