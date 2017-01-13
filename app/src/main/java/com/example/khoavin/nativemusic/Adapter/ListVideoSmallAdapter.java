package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.R;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;

/**
 * Created by OatOal on 12/01/2017.
 */

public class ListVideoSmallAdapter extends BaseAdapter {
    private Context mContext;
    private Video[] mVideoSource;

    public ListVideoSmallAdapter(Context c, Video[] videoSource){
        mContext = c;
        mVideoSource = videoSource;
    }
    @Override
    public int getCount() {
        return mVideoSource.length;
    }

    @Override
    public Object getItem(int position) {
        return mVideoSource[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView;
        listView = convertView;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.single_video_small,parent, false);

            TextView videoName = (TextView)listView.findViewById(R.id.video_name_small);
            ImageView videoImage = (ImageView)listView.findViewById(R.id.video_image_small);
            TextView listenerCount = (TextView)listView.findViewById(R.id.video_listener_count_small);
            TextView singer = (TextView)listView.findViewById(R.id.video_singer_small);

            videoName.setText(mVideoSource[position].GetName());
            videoImage.setImageResource(mVideoSource[position].GetVideoImage());
            singer.setText(mVideoSource[position].GetSinger());
            listenerCount.setText(FormatListenerCount(mVideoSource[position].GetListenerCount()));
        }
        else{
            listView = (View)convertView;
        }
        return listView;
    }
}
