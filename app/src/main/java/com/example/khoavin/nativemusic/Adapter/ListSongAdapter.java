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

/**
 * Created by KhoaVin on 19/12/2016.
 */

public class ListSongAdapter extends BaseAdapter {
    private Context mContext;
    private String[] songNames;
    private int[] Images;
    private String[] songSingers;
    private String[] hearNumbers;
    public ListSongAdapter(Context c,String[] names,int[] images, String[] songSingers, String[] hearNumbers){
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
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.single_song,parent,false);
            ImageView singerImage = (ImageView) listView.findViewById(R.id.singer_image);
            TextView songName = (TextView)listView.findViewById(R.id.song_name);
            TextView songSinger = (TextView)listView.findViewById(R.id.song_singer);
            TextView hearNumber = (TextView)listView.findViewById(R.id.song_hearnumber);
            Button btn_threedots = (Button)listView.findViewById(R.id.btn_three_dots);
            btn_threedots.setOnClickListener(new View.OnClickListener() {
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

            singerImage.setImageResource(Images[position]);
            songName.setText(songNames[position]);
            songSinger.setText(songSingers[position]);
            hearNumber.setText(hearNumbers[position]);
        }
        else{
            listView = (View)convertView;
        }
        return listView;
    }
}
