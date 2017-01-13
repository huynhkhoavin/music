package com.example.khoavin.nativemusic.Tabs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.NormalPlayListAdapter;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class PlayListTab extends Fragment {

    GridView grid;

    NormalPlayList[] dataSource = new NormalPlayList[]
    {
            new NormalPlayList("Cẩm Ly", R.drawable.nhac_dan_ca_1, "", 325000, "Em gái quê"),
            new NormalPlayList("Quang Dũng", R.drawable.nhac_dan_ca_2, "", 325000, "Dũng kẹo"),
            new NormalPlayList("Đàm Vĩnh Hưng", R.drawable.nhac_dan_ca_3, "", 325000, "Đêm lang thang"),
            new NormalPlayList("Đan Trường", R.drawable.nhac_dan_ca_4, "", 325000, "Mãi mãi một tình yêu"),
            new NormalPlayList("Hồ Ngọc Hà", R.drawable.nhac_dan_ca_5, "", 325000, "Qua con mê"),
            new NormalPlayList("Duy Mạnh", R.drawable.nhac_dan_ca_6, "", 325000, "Thánh tru"),
            new NormalPlayList("Chó Phước Thịnh", R.drawable.nhac_dan_ca_7, "", 325000, "Gâu Gâu Gâu"),
            new NormalPlayList("Sơn Tùng MTP", R.drawable.nhac_dan_ca_8, "", 325000, "Lạc trôi"),
            new NormalPlayList("Bảo Thy", R.drawable.nhac_dan_ca_1, "", 325000, "Ngôi nhà hoa hồng"),
            new NormalPlayList("Vi Tiểu Bảo", R.drawable.nhac_dan_ca_2, "", 325000, "Chém gió siêu hạng"),
            new NormalPlayList("Hoàng Lão Tà", R.drawable.nhac_dan_ca_3, "", 325000, "Đàn chỉ thần công"),
            new NormalPlayList("Tây Độc", R.drawable.nhac_dan_ca_4, "", 325000, "Âu Dương Phong")
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist_fragment,container,false);
        //ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.white);
        Bitmap blurBitmap = BlurBuilder.blur(bitmap,this.getContext());
        //view.setBackground(new BitmapDrawable(getResources(), bitmap));

        //region GRIDVIEW
        NormalPlayListAdapter adapter = new NormalPlayListAdapter(getActivity().getBaseContext(),dataSource);

        grid = (GridView)view.findViewById(R.id.playlist_gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /*Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(getActivity(),view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(),"Popup : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();//showing popup menu*/
            }
        });

        return view;
    }

}
