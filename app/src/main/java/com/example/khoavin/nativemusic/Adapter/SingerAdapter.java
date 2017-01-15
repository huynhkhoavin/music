package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.khoavin.nativemusic.DataObject.Artist;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.R;

/**
 * Created by OatOal on 17/12/2016.
 */

public class SingerAdapter extends BaseAdapter {
    private Context mContext;

    private Artist[] mSource;


    public SingerAdapter(Context c, Artist[] source){
        mContext = c;
        mSource = source;
    }
    @Override
    public int getCount() {
        return mSource.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        grid = convertView;
        ViewHolder holder = null;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.single_singer,parent,false);

            holder = new ViewHolder();
            holder.image = (ImageView) grid.findViewById(R.id.singer_image);
            holder.songName= (TextView)grid.findViewById(R.id.singer_name);

            grid.setTag(holder);
        }
        else{
            holder = (ViewHolder)grid.getTag();
        }

        holder.image.setImageResource(mSource[position].getImage());
        holder.songName.setText(mSource[position].getArtistName());
        return grid;
    }

    private class ViewHolder
    {
        public ImageView image;
        public TextView songName;
    }
}
