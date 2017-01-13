package com.example.khoavin.nativemusic.DataObject;

/**
 * Created by OatOal on 1/13/2017.
 */

public class NormalPlayList {


    public NormalPlayList(String singerName, int playListImage, String playListImageUrl, long listenerCount, String playListName) {
        this.singerName = singerName;
        this.playListImage = playListImage;
        this.playListImageUrl = playListImageUrl;
        this.listenerCount = listenerCount;
        this.playListName = playListName;
    }

    public int getPlayListImage() {
        return playListImage;
    }

    public void setPlayListImage(int playListImage) {
        this.playListImage = playListImage;
    }

    private int playListImage;

    public String getPlayListImageUrl() {
        return playListImageUrl;
    }

    public void setPlayListImageUrl(String playListImageUrl) {
        this.playListImageUrl = playListImageUrl;
    }

    private String playListImageUrl;

    public long getListenerCount() {
        return listenerCount;
    }

    public void setListenerCount(long listenerCount) {
        this.listenerCount = listenerCount;
    }

    private long listenerCount;

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    private String playListName;

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    private  String singerName;
}
