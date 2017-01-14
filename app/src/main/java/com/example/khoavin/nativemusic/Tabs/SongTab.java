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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.GridViewAdapter;
import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;

/**
 * Created by KhoaVin on 12/12/2016.
 */

public class SongTab extends Fragment {
    ListView listView;
    String[] songNames = {
            "Hương Lúa Mạ Non",
            "Nỗi Buồn Mẹ Tôi",
            "Chân Tình",
            "Hào Hoa",
            "Cha Chồng Nàng Dâu",
            "Xuân Này Con Không Về",
            "Gọi Đò",
            "Đồi Hoa Sim",
            "Căn Nhà Ngoại Ô"
                } ;
    int[] songImage = {
            R.drawable.quang_le,
            R.drawable.nhac_dan_ca,
            R.drawable.quang_dung,
            R.drawable.vinh_thuyen_kim,
            R.drawable.nhat_kim_anh,
            R.drawable.dan_nguyen,
            R.drawable.duong_ngoc_thai,
            R.drawable.tuan_vu,
            R.drawable.truong_vu

    };
    int[] songImage2 = {
            R.drawable.quang_le,
            R.drawable.quang_le,
            R.drawable.quang_le,
            R.drawable.quang_le,
            R.drawable.quang_le,
            R.drawable.quang_le,
            R.drawable.quang_le,
            R.drawable.quang_le,
            R.drawable.quang_le

    };
    String[] songSinger = {
        "Quang Lê",
        "Cẩm Ly",
        "Quang Dũng",
        "Vĩnh Thuyên Kim",
        "Nhật Kim Anh",
        "Đan Nguyên",
        "Dương Ngọc Thái",
        "Tuấn Vũ",
        "Trường Vũ"
    };
    long[] hearNumbers = {
            10000,
            9000,
            7000,
            735000,
            78000000,
            3652014,
            2152026,
            548922,
            447656
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_fragment,container,false);

        //region GRIDVIEW
        ListSongAdapter adapter = new ListSongAdapter(getActivity().getBaseContext(),songNames,songImage2,songSinger,hearNumbers);
        listView = (ListView)view.findViewById(R.id.song_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +songNames[+ position], Toast.LENGTH_SHORT).show();
            }
        });
        listView = (ListView) view.findViewById(R.id.horizontal_listview);
        //endregion
        return view;
    }
}
