package com.example.khoavin.nativemusic.Tabs;

import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.support.v8.renderscript.*;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.MainActivity;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;

import static android.view.View.VISIBLE;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.PlaylistCollectionSource;
/**
 * Created by KhoaVin on 12/12/2016.
 */

public class HomeTab extends Fragment {
    GridView grid;
    GridView grid2;
    ListView listView;
    NormalPlayList[] dataSource;

    int[] listImage = {
            R.drawable.duong_ngoc_thai,
            R.drawable.quang_dung,
            R.drawable.quang_le,
            R.drawable.lactroi_music,
            R.drawable.duong_ngoc_thai,
            R.drawable.quang_dung,
            R.drawable.quang_le,
            R.drawable.lactroi_music,
            R.drawable.lactroi_music
    };
    String[] listSongName = {"Éo Le Cuộc Tình","Anh Còn Nợ Em", "Xuân Này Con Không Về","Cơn Mưa Ngang Qua","Éo Le Cuộc Tình","Anh Còn Nợ Em", "Xuân Này Con Không Về","Cơn Mưa Ngang Qua","Cơn Mưa Ngang Qua"};
    String[] listSingerName = {"Dương Ngọc Thái", "Quang Dũng", "Quang Lê", "Sơn Tùng M-TP","Dương Ngọc Thái", "Quang Dũng", "Quang Lê", "Sơn Tùng M-TP","Sơn Tùng M-TP"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        //ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.white);
        Bitmap blurBitmap = BlurBuilder.blur(bitmap,this.getContext());
        //view.setBackground(new BitmapDrawable(getResources(), bitmap));

        dataSource = PlaylistCollectionSource;
        //region GRIDVIEW
        GridViewAdapter adapter = new GridViewAdapter(getActivity().getBaseContext(),listImage,listSongName,listSingerName);
        grid = (GridView)view.findViewById(R.id.grid_view);
        grid2 = (GridView)view.findViewById(R.id.grid_view2);
        grid.setAdapter(adapter);
        grid2.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(getActivity(),view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(),"Popup : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();//showing popup menu
            }
        });
        //endregion

        //endregion
        return view;
    }

}
