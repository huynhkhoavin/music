package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khoavin.nativemusic.R;

import java.util.List;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.FormatListenerCount;

/**
 * Created by KhoaVin on 12/01/2017.
 */

public class PlaylistAdapter extends BaseAdapter {
    private static final int HEAD = 0;
    private static final int ITEM = 1;
    Context context;
    int[] sequences;
    int[] backgrounds;
    String[] songNames;
    String[] singers;
    long[] hearNumbers;
    public PlaylistAdapter(Context context, int[] seq, String[] songNames, String[] singers, long[] hearNumber){
        this.context = context;
        this.sequences = seq;
        this.songNames = songNames;
        this.singers = singers;
        this.hearNumbers = hearNumber;
    }
    int type;

    @Override
    public int getItemViewType(int position) {

        if (position== 0){
            type = HEAD;
        } else if  (position >= 1){
            type = ITEM;
        }
        return type;
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getCount() {
        return this.songNames.length + 1;
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
    public View getView(int position, final View convertView, ViewGroup parent) {
        View listView;
        listView = convertView;

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (position==0){
                listView = inflater.inflate(R.layout.header_small_list,parent,false);
                Button three_dots = (Button)listView.findViewById(R.id.btn_three_dots);
                three_dots.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
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
            }
            else {
                listView = inflater.inflate(R.layout.single_small_list,parent,false);
                TextView sequenceNumber = (TextView)listView.findViewById(R.id.small_list_tv);
                TextView songName = (TextView)listView.findViewById(R.id.small_list_songname);
                TextView singer = (TextView)listView.findViewById(R.id.small_list_singer);
                TextView hearNumber = (TextView)listView.findViewById(R.id.small_list_hearnumber);

                sequenceNumber.setText("0"+String.valueOf(sequences[position-1]));
                songName.setText(songNames[position-1]);
                singer.setText(singers[position-1]);
                hearNumber.setText(FormatListenerCount(hearNumbers[position-1]));
                Button three_dots = (Button)listView.findViewById(R.id.btn_three_dots);
                three_dots.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
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
            }
        }
        else{
            listView = (View)convertView;
        }
        return listView;
    }
}
