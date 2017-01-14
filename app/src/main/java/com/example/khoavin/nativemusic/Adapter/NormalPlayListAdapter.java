package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.R;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;

/**
 * Created by KhoaVin on 17/12/2016.
 */

public class NormalPlayListAdapter extends BaseAdapter {
    private Context mContext;
    private NormalPlayList[] mDataSource;
    public NormalPlayListAdapter(Context c,NormalPlayList[] dataSource){
        mContext = c;
        mDataSource = dataSource;
    }
    @Override
    public int getCount() {
        return mDataSource.length;
    }

    @Override
    public Object getItem(int position) {
        return mDataSource[position];
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
            grid = inflater.inflate(R.layout.single_playlist_no_details, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView)grid.findViewById(R.id.playlist_name);
            holder.image = (ImageView)grid.findViewById(R.id.playlist_image);
            holder.listenerCount = (TextView)grid.findViewById(R.id.playlist_listener_count);
            holder.singer = (TextView)grid.findViewById(R.id.playlist_singer);

            grid.setTag(holder);
        }
        else{
            holder = (ViewHolder)grid.getTag();
        }

        holder.name.setText(mDataSource[position].getPlayListName());
        holder.image.setImageResource(mDataSource[position].getPlayListImage());
        holder.listenerCount.setText(FormatListenerCount(mDataSource[position].getListenerCount()));
        holder.singer.setText(mDataSource[position].getSingerName());

        return grid;
    }

    private class ViewHolder
    {
        public TextView name;
        public ImageView image;
        public TextView listenerCount;
        public TextView singer;
    }
}
