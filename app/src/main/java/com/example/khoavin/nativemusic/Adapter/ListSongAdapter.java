package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khoavin.nativemusic.R;

import static com.example.khoavin.nativemusic.R.id.imageView;
import static com.example.khoavin.nativemusic.R.id.textView;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;

/**
 * Created by KhoaVin on 19/12/2016.
 */

public class ListSongAdapter extends BaseAdapter {
    private Context mContext;
    private String[] songNames;
    private int[] Images;
    private String[] songSingers;
    private long[] hearNumbers;
    public ListSongAdapter(Context c,String[] names,int[] images, String[] songSingers, long[] hearNumbers){
        mContext = c;
        songNames = names;
        this.songSingers = songSingers;
        this.hearNumbers = hearNumbers;
        Images = images;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listView;
        listView = convertView;
        ViewHolder holder = null;

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.single_song,parent,false);

            holder = new ViewHolder();
            holder.singerImage = (ImageView) listView.findViewById(R.id.singer_image);
            holder.songName = (TextView)listView.findViewById(R.id.song_name);
            holder.songSinger = (TextView)listView.findViewById(R.id.song_singer);
            holder.hearNumber = (TextView)listView.findViewById(R.id.song_hearnumber);
            holder.btn_threedots = (Button)listView.findViewById(R.id.btn_three_dots);

            listView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listView.getTag();
        }

        holder.btn_threedots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Toast.makeText(v.getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(v.getContext(),"Popup : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();//showing popup menu
            }
        });

        holder.singerImage.setImageResource(Images[position]);
        holder.songName.setText(songNames[position]);
        holder.songSinger.setText(songSingers[position]);
        holder.hearNumber.setText(FormatListenerCount(hearNumbers[position]));

        return listView;
    }

    private class ViewHolder
    {
        public ImageView singerImage;
        public TextView songName;
        public TextView songSinger;
        public TextView hearNumber;
        public Button btn_threedots;
    }

}
