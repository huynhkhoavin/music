package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.media.MediaRecorder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.R;

/**
 * Created by OatOal on 12/01/2017.
 */

public class ListVideoAdapter extends BaseAdapter {
    private Context mContext;

    private Video[] mVideoSource;

    public ListVideoAdapter(Context c, Video[] videoSource){
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
            listView = inflater.inflate(R.layout.single_video, parent, false);

            TextView videoName = (TextView)listView.findViewById(R.id.video_name_parent);
            ImageView videoImage = (ImageView)listView.findViewById(R.id.video_image_parent);
            TextView listenerCount = (TextView)listView.findViewById(R.id.video_listener_count_parent);
            TextView singer = (TextView)listView.findViewById(R.id.video_singer_parent);

            videoName.setText(mVideoSource[position].GetName());
            videoImage.setImageResource(mVideoSource[position].GetVideoImage());
            singer.setText(mVideoSource[position].GetSinger());
            listenerCount.setText(mVideoSource[position].GetListenerCountString());
        }
        else{
            listView = (View)convertView;
        }
        return listView;
    }
}
