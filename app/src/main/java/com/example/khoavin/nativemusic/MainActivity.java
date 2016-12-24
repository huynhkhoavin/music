package com.example.khoavin.nativemusic;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.khoavin.nativemusic.Adapter.TabPagerAdapter;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    //region VIEWPAGER+ACTIONBAR
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private ActionBar actionBar;
    private String[] tabName = {"First","Second","Third"};
    //endregion
    //region SLIDE PANEL
    SlidingUpPanelLayout slidingLayout;
    //Button btnShow;
    //Button btnHide;
    //TextView textView;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //region ACTION BAR
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.maxresdefault);
        Bitmap blurBitmap = BlurBuilder.blur(bitmap,getBaseContext());
        //view.setBackground(new BitmapDrawable(getResources(), bitmap));

        View view = this.getWindow().getDecorView();
        view.setBackgroundDrawable(new BitmapDrawable(getResources(),bitmap));
        actionBar.setStackedBackgroundDrawable(new BitmapDrawable(getResources(),bitmap));
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("HOME").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("PLAYLIST").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("BÀI HÁT").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("VIDEO").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("BXH").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("NGHỆ SĨ ").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("CHỦ ĐỀ").setTabListener(this));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //endregion
        //region SLIDE
//        btnShow = (Button)findViewById(R.id.btn_show);
//        btnHide = (Button)findViewById(R.id.btn_hide);
//        textView = (TextView)findViewById(R.id.text);

        slidingLayout = (SlidingUpPanelLayout)findViewById(R.id.sliding_layout);
        slidingLayout.setPanelSlideListener(onSlideListener());
//        btnHide.setOnClickListener(onHideListener());
//        btnShow.setOnClickListener(onShowListener());
        //endregion
    }

    @Override
    public void onAttachFragment(Fragment fragment){
    }
    private View.OnClickListener onShowListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show sliding layout in bottom of screen (not expand it)
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
//                btnShow.setVisibility(View.GONE);
            }
        };
    }

    private View.OnClickListener onHideListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide sliding layout
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
//                btnShow.setVisibility(View.VISIBLE);
            }
        };
    }

    private SlidingUpPanelLayout.PanelSlideListener onSlideListener() {
        return new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View view, float v) {
//                textView.setText("panel is sliding");
            }

            @Override
            public void onPanelCollapsed(View view) {
//                textView.setText("panel Collapse");
                actionBar.show();
            }

            @Override
            public void onPanelExpanded(View view) {
//                textView.setText("panel expand");
                actionBar.hide();
            }

            @Override
            public void onPanelAnchored(View view) {
//                textView.setText("panel anchored");
            }

            @Override
            public void onPanelHidden(View view) {
//                textView.setText("panel is Hidden");
            }
        };
    }

    //region Tab Method
    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
    //endregion


}
