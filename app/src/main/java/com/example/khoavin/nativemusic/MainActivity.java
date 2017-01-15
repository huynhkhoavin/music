package com.example.khoavin.nativemusic;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.Adapter.ListSongAdapter;
import com.example.khoavin.nativemusic.Adapter.TabPagerAdapter;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import co.mobiwise.library.InteractivePlayerView;
import co.mobiwise.library.OnActionClickedListener;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.SongCollectionSource;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener,OnActionClickedListener {
    //region VIEWPAGER+ACTIONBAR
    private ViewPager viewPager;
    ImageButton playbtn;
    TextView SongTitle;
    TextView SingerName;
    private TabPagerAdapter tabPagerAdapter;
    SimpleSong[] collectionSource = SongCollectionSource;
    private ActionBar actionBar;
    private String[] tabName = {"First","Second","Third"};
    //endregion
    //region SLIDE PANEL
    public SlidingUpPanelLayout slidingLayout;
    //Button btnShow;
    //Button btnHide;
    //TextView textView;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdded();
        //region ACTION BAR
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setDisplayShowTitleEnabled(false);
        this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
        //actionBar.hide();
        View view = this.getWindow().getDecorView();
        //view.setBackgroundColor(getResources().getColor(R.color.background_color));
        view.setBackgroundResource(R.drawable.gradient_background);

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

        SongTitle = (TextView)findViewById(R.id.musicTitle);
        SingerName = (TextView)findViewById(R.id.musicArtistName);
        final Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.song_anim);

        playbtn = (ImageButton)findViewById(R.id.Play_btn);
        playbtn.setBackgroundResource(R.drawable.playing_play_normal);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mInteractivePlayerView.isPlaying()) {
                    mInteractivePlayerView.start();
                    playbtn.setBackgroundResource(R.drawable.playing_pause_normal);

                } else {
                    mInteractivePlayerView.stop();
                    playbtn.setBackgroundResource(R.drawable.playing_play_normal);
                }
            }
        });
        //endregion
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Intent it = new Intent(this, SettingActivity.class);
//            startActivity(it);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

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
       System.out.println(fragment.getId());
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
                playbtn.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPanelCollapsed(View view) {
//                textView.setText("panel Collapse");
                actionBar.show();
                playbtn.setBackgroundResource(R.drawable.playing_play_normal);
                playbtn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPanelExpanded(View view) {
//                textView.setText("panel expand");
                actionBar.hide();
                playbtn.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPanelAnchored(View view) {
//                textView.setText("panel anchored");
                playbtn.setBackgroundResource(R.drawable.playing_play_normal);
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
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    //endregion
    //region Animation
    public void play_move_up(View view){

    }
    //endregion
    //region ListView
public void setListAdded(){
    ListSongAdapter listSongAdapter = new ListSongAdapter(getBaseContext(),collectionSource);
    ListView listView = (ListView)findViewById(R.id.lastest_added_lv);
    listView.setAdapter(listSongAdapter);
}
    //endregion
}
