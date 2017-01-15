package com.example.khoavin.nativemusic.Tabs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.support.v8.renderscript.*;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.Adapter.TopicMainmenuAdapter;
import com.example.khoavin.nativemusic.Adapter.VideoMainmenuAdapter;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;
import com.example.khoavin.nativemusic.DataObject.Topic;
import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.MainActivity;
import com.example.khoavin.nativemusic.PlaylistPlayerActivity;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;
import com.example.khoavin.nativemusic.TopicDetailsActivity;
import com.example.khoavin.nativemusic.VideoPlayerActivity;

import static android.view.View.VISIBLE;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.*;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class HomeTab extends Fragment {
    GridView albumGrid;
    GridView videoGrid;
    GridView topicGrid;
    GridView songGrid;

    NormalPlayList[] albumSource;
    Video[] videoDataSource;
    Topic[] topicSource;
    SimpleSong[] songSource;

    //View ViewFlipper
    ViewFlipper viewFlipper;

//    int[] listImage = {
//            R.drawable.duong_ngoc_thai,
//            R.drawable.quang_dung,
//            R.drawable.quang_le,
//            R.drawable.lactroi_music,
//            R.drawable.duong_ngoc_thai,
//            R.drawable.quang_dung,
//            R.drawable.quang_le,
//            R.drawable.lactroi_music,
//            R.drawable.lactroi_music
//    };
//    String[] listSongName = {"Éo Le Cuộc Tình","Anh Còn Nợ Em", "Xuân Này Con Không Về","Cơn Mưa Ngang Qua","Éo Le Cuộc Tình","Anh Còn Nợ Em", "Xuân Này Con Không Về","Cơn Mưa Ngang Qua","Cơn Mưa Ngang Qua"};
//    String[] listSingerName = {"Dương Ngọc Thái", "Quang Dũng", "Quang Lê", "Sơn Tùng M-TP","Dương Ngọc Thái", "Quang Dũng", "Quang Lê", "Sơn Tùng M-TP","Sơn Tùng M-TP"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        //ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.white);
        Bitmap blurBitmap = BlurBuilder.blur(bitmap,this.getContext());
        //view.setBackground(new BitmapDrawable(getResources(), bitmap));

        albumSource = MainmenuAlbumCollectionSource;
        videoDataSource = MainmenuVideoCollectionSource;
        topicSource = MainmenuTopicCollectionSource;
        songSource = MainmenuSongCollectionSource;

        //region GRIDVIEW

        albumGrid = (GridView)view.findViewById(R.id.album_grid);
        videoGrid = (GridView)view.findViewById(R.id.video_grid);
        topicGrid = (GridView)view.findViewById(R.id.topic_grid);
        songGrid = (GridView)view.findViewById(R.id.song_grid);

        GridViewAdapter albumAdapter = new GridViewAdapter(getActivity().getBaseContext(), albumSource);
        VideoMainmenuAdapter videoAdapter = new VideoMainmenuAdapter(getActivity().getBaseContext(), videoDataSource);
        TopicMainmenuAdapter topicAdater = new TopicMainmenuAdapter(getActivity().getBaseContext(), topicSource);
        ListSongAdapter songAdapter = new ListSongAdapter(getActivity().getBaseContext(), songSource);

        albumGrid.setAdapter(albumAdapter);
        videoGrid.setAdapter(videoAdapter);
        topicGrid.setAdapter(topicAdater);
        songGrid.setAdapter(songAdapter);

        videoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Video item = (Video) parent.getItemAtPosition(position);

                if(item != null)
                {
                    Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
                    intent.putExtra("VIDEO_NAME", item.GetName());
                    intent.putExtra("VIDEO_IMAGE", item.GetVideoImage());
                    intent.putExtra("VIDEO_LISTENER_COUNT", item.GetListenerCount());
                    intent.putExtra("VIDEO_SINGER", item.GetSinger());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getContext(), "No item found!", Toast.LENGTH_LONG);
                }
            }
        });

        topicGrid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Topic item = (Topic) parent.getItemAtPosition(position);

                if(item != null)
                {
                    Intent intent = new Intent(getActivity(), TopicDetailsActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getActivity(), PlayerActivity.class);
                    //startActivity(intent);

                    //getFragmentManager().beginTransaction().replace(R.id.content, new PlayListTab()).addToBackStack(null).commit();
                }
            }
        });

//        albumGrid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                NormalPlayList item = (NormalPlayList)parent.getItemAtPosition(position);
//
//                if(item != null)
//                {
//                    Intent intent = new Intent(getActivity(), PlaylistPlayerActivity.class);
//                    intent.putExtra("PLAYLIST_IMAGE", item.getPlayListImage());
//                    intent.putExtra("PLAYLIST_LISTENER_COUNT", item.getListenerCount());
//                    startActivity(intent);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "No item found!", Toast.LENGTH_LONG);
//                }
//            }
//        });

        albumGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NormalPlayList item = (NormalPlayList)parent.getItemAtPosition(position);

                if(item != null)
                {
                    Intent intent = new Intent(getActivity(), PlaylistPlayerActivity.class);
                    intent.putExtra("PLAYLIST_IMAGE", item.getPlayListImage());
                    intent.putExtra("PLAYLIST_LISTENER_COUNT", item.getListenerCount());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getContext(), "No item found!", Toast.LENGTH_LONG);
                }

            }
        });

        //ViewFlipper
        this.viewFlipper = (ViewFlipper)view.findViewById(R.id.viewFlipper);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getActivity().getBaseContext(), R.anim.in_from_right));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity().getBaseContext(), R.anim.out_from_left));
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(3000);

        return view;
    }

}
