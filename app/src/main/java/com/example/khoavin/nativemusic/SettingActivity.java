package com.example.khoavin.nativemusic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class SettingActivity extends AppCompatActivity {

    String[] account = {"khoavin@gmail.com","12520504@gm.uit.edu.vn"};
    String[] music = {"Bộ hiệu chỉnh âm thanh"};
    String[] intro = {"Giới thiệu về sản phẩm","Phản hồi từ người dùng"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);
        ArrayAdapter<String> adapter_account = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,account);
        ArrayAdapter<String> adapter_music = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,music);
        ArrayAdapter<String> adapter_intro = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,intro);
        ListView account_lv = (ListView)findViewById(R.id.acc_lv);
        account_lv.setAdapter(adapter_account);
        ListView music_lv = (ListView)findViewById(R.id.music_lv);
        music_lv.setAdapter(adapter_music);
        ListView intro_lv = (ListView)findViewById(R.id.introduce_lv);
        intro_lv.setAdapter(adapter_intro);
    }
}
