package com.example.khoavin.nativemusic.DataObject;

/**
 * Created by OatOal on 1/14/2017.
 */

public class Topic {
    //Topic Name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Topic Image
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    //Constructor
    public Topic(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
