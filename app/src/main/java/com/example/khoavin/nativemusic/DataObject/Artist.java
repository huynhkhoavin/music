package com.example.khoavin.nativemusic.DataObject;

/**
 * Created by OatOal on 1/15/2017.
 */

public class Artist {

    private int image;
    private String artistName;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String singerName) {
        this.artistName = singerName;
    }

    public Artist(String singerName, int image) {
        this.image = image;
        this.artistName = singerName;
    }
}
