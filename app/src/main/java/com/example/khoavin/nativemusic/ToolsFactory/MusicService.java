package com.example.khoavin.nativemusic.ToolsFactory;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.khoavin.nativemusic.DataObject.Song;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by KhoaVin on 28/12/2016.
 */

public class MusicService extends Service implements MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener {

    //region Media Player
    //Player
    private MediaPlayer player;
    //Song List
    private ArrayList<Song> songs;
    //Song position
    private int songPos;
    //endregion

    private final IBinder musicBind = new MusicBinder();
    @Override
    public void onCreate(){
        super.onCreate();
        songPos = 0;
        player = new MediaPlayer();
        initMusicPlayer();
    }

    //Init music player
    public void initMusicPlayer(){
        player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
    }
    public void playSong(Uri uri){
        player.reset();
        Song playSong = songs.get(songPos);
        long currentSong = playSong.getID();
        Uri trackUri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,currentSong);
        try{
        player.setDataSource(getApplicationContext(),uri);
        }catch (Exception e){
            Log.e("MUSIC SERVICE", "Error setting data source", e);
        }
        player.prepareAsync();
    }
    //Add SongList
    public void setSongList(ArrayList<Song> theSong){
        songs = theSong;
    }
    //Inner class
    public class MusicBinder extends Binder {

        public MusicService getService(){
            return MusicService.this;
        }
    }
    public void setSong(int songIndex){
        songPos = songIndex;
    }
    //region Override
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    @Override
    public boolean onUnbind(Intent intent){
        player.stop();
        player.release();
        return false;
    }
    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }
    //endregion
}
