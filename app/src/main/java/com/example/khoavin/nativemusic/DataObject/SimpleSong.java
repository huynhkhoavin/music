package com.example.khoavin.nativemusic.DataObject;

/**
 * Created by OatOal on 1/14/2017.
 */

public class SimpleSong {

    private String name;
    private int image;
    private long listenerCount;
    private String singer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public long getListenerCount() {
        return listenerCount;
    }

    public void setListenerCount(long listenerCount) {
        this.listenerCount = listenerCount;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public SimpleSong(String name, int image, long listenerCount, String singer) {
        this.name = name;
        this.image = image;
        this.listenerCount = listenerCount;
        this.singer = singer;
    }
}
