package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.DataObject.Topic;
import com.example.khoavin.nativemusic.R;

/**
 * Created by OatOal on 12/01/2017.
 */

public class TopicMainmenuAdapter extends BaseAdapter {
    private Context mContext;

    private Topic[] topicSource;

    public TopicMainmenuAdapter(Context c, Topic[] topicSource){
        mContext = c;
        this.topicSource = topicSource;
    }
    @Override
    public int getCount() {
        return topicSource.length;
    }

    @Override
    public Object getItem(int position) {
        return topicSource[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView;
        listView = convertView;
        ViewHolder holder = null;

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.single_topic_mainmenu, parent, false);

            holder = new ViewHolder();
            holder.topicNamme = (TextView)listView.findViewById(R.id.topic_name);
            holder.topicImage = (ImageView)listView.findViewById(R.id.topic_image);

            listView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)listView.getTag();
        }

        holder.topicNamme.setText(topicSource[position].getName());
        holder.topicImage.setImageResource(topicSource[position].getImage());

        return listView;
    }


    private  class ViewHolder
    {
        public  TextView topicNamme;
        public  ImageView topicImage;
    }
}
