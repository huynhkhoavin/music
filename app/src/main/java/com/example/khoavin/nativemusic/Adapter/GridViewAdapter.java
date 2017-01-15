package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.khoavin.nativemusic.R;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;

/**
 * Created by KhoaVin on 17/12/2016.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private int[] listImages;
    private String[] listSongNames;
    private String[] listSingerNames;
    public GridViewAdapter(Context c,int[] listImage,String[] listSongName, String[] listSingerName){
        mContext = c;
        this.listImages = listImage;
        this.listSongNames = listSongName;
        this.listSingerNames = listSingerName;
    }
    @Override
    public int getCount() {
        return listImages.length;
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
        GridViewAdapter.ViewHolder holder = null;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.single_grid,parent,false);

            holder = new GridViewAdapter.ViewHolder();
            holder.image = (LinearLayout) grid.findViewById(R.id.linear_layout);
            holder.songName= (TextView)grid.findViewById(R.id.grid_songname);
            holder.singerName = (TextView)grid.findViewById(R.id.grid_singername);

            grid.setTag(holder);
        }
        else{
            holder = (GridViewAdapter.ViewHolder)grid.getTag();
        }

        holder.image.setBackgroundResource(listImages[position]);
        holder.songName.setText(listSongNames[position]);
        holder.singerName.setText(listSingerNames[position]);
        return grid;
    }

    private class ViewHolder
    {
        public LinearLayout image;
        public TextView songName;
        public TextView singerName;
    }
}
