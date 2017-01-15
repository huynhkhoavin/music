package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.DataObject.KindOfMusic;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.R;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;

/**
 * Created by ÔatOal on 17/12/2016.
 */

public class BottomSheetAdapter extends BaseAdapter {
    private Context mContext;
    private KindOfMusic[] mDataSource;
    public BottomSheetAdapter(Context c, KindOfMusic[] dataSource){
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
            grid = inflater.inflate(R.layout.single_bottom_sheet, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView)grid.findViewById(R.id.the_loai_nhac);
            grid.setTag(holder);
        }
        else{
            holder = (ViewHolder)grid.getTag();
        }

        holder.name.setText(mDataSource[position].getName());

        return grid;
    }

    private class ViewHolder
    {
        public TextView name;
    }
}
