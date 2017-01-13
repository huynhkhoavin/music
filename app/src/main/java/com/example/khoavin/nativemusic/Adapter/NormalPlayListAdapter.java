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
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.single_playlist_no_details, parent, false);

            TextView name = (TextView)grid.findViewById(R.id.playlist_name);
            ImageView image = (ImageView)grid.findViewById(R.id.playlist_image);
            TextView listenerCount = (TextView)grid.findViewById(R.id.playlist_listener_count);
            TextView singer = (TextView)grid.findViewById(R.id.playlist_singer);

            name.setText(mDataSource[position].getPlayListName());
            image.setImageResource(mDataSource[position].getPlayListImage());
            listenerCount.setText(FormatListenerCount(mDataSource[position].getListenerCount()));
            singer.setText(mDataSource[position].getSingerName());
        }
        else{
            grid = (View)convertView;
        }
        return grid;
    }
}
