package com.example.khoavin.nativemusic;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.khoavin.nativemusic.Adapter.TabPagerAdapter;
import com.example.khoavin.nativemusic.DataObject.Song;
import com.example.khoavin.nativemusic.ToolsFactory.BlurBuilder;
import com.example.khoavin.nativemusic.ToolsFactory.EqualizerActivity;
import com.example.khoavin.nativemusic.ToolsFactory.MusicService;
import com.example.khoavin.nativemusic.ToolsFactory.MusicService.MusicBinder;
import com.example.khoavin.nativemusic.ToolsFactory.RoundImage;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

import co.mobiwise.library.InteractivePlayerView;
import co.mobiwise.library.OnActionClickedListener;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener,OnActionClickedListener {
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
        //actionBar.setDisplayShowTitleEnabled(true);
        this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
        //actionBar.hide();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.background);
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
//        ImageView song_image = (ImageView)findViewById(R.id.song_image);
//            Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.nhac_dan_ca);
//            RoundImage roundImage = new RoundImage(bitmap2);
//            song_image.setImageDrawable(roundImage);

        //endregion
        //region Background Music
//        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.alone);
//        mediaPlayer.start();
        //endregion
        //region InterativePlayerView
        final InteractivePlayerView mInteractivePlayerView = (InteractivePlayerView) findViewById(R.id.interactivePlayerView);
        mInteractivePlayerView.setMax(114);
        mInteractivePlayerView.setProgress(50);
        mInteractivePlayerView.setOnActionClickedListener(this);

        final ImageView imageView = (ImageView) findViewById(R.id.control);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mInteractivePlayerView.isPlaying()) {
                    mInteractivePlayerView.start();
                    imageView.setBackgroundResource(R.drawable.ic_action_pause);
                } else {
                    mInteractivePlayerView.stop();
                    imageView.setBackgroundResource(R.drawable.ic_action_play);
                }
            }
        });
        //endregion
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent it = new Intent(this, SettingActivity.class);
            startActivity(it);
        }

        return super.onOptionsItemSelected(item);
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
    //region Others Method
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
                //actionBar.show();
            }

            @Override
            public void onPanelExpanded(View view) {
//                textView.setText("panel expand");
                //actionBar.hide();
            }

            @Override
            public void onPanelAnchored(View view) {
//                textView.setText("panel anchored");
            }

            @Override
            public void onPanelHidden(View view) {
                Log.e("onPanelHidden","Panel Hidden");
            }
        };
    }

    @Override
    public void onActionClicked(int id) {
        switch (id) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    //endregion
    //region Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //endregion
}
