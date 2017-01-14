package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.R;

/**
 * Created by KhoaVin on 19/12/2016.
 */

public class ListSongAdapter extends BaseAdapter {
    private Context mContext;
    private String[] Names;
    private int[] Images;
    public ListSongAdapter(Context c,String[] names,int[] images){
        mContext = c;
        Names = names;
        Images = images;
    }
    @Override
    public int getCount() {
        return Names.length;
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
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.single_song,null);

            holder = new ViewHolder();
            holder.textView = (TextView)listView.findViewById(R.id.song_name);
            holder.imageView = (ImageView)listView.findViewById(R.id.song_image);

            listView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textView.setText(Names[position]);
        //System.out.println(imageId[position]+" - - "+R.drawable.nhac_dan_ca);
//            Bitmap bitmap = BitmapFactory.decodeResource(listView.getResources(),imageId[position]);
//            RoundImage roundImage = new RoundImage(bitmap);
//            imageView.setImageDrawable(roundImage);
        holder.imageView.setImageResource(Images[position]);

        return listView;
    }

    private class ViewHolder
    {
        public TextView textView;
        public ImageView imageView;
    }
}
