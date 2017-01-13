package com.example.khoavin.nativemusic.DataObject;

/**
 * Created by OatOal on 1/12/2017.
 */

public class Video {

    //The video's name
    private String _videoName;

    //Video name getter and setter
    public String GetName(){return _videoName;}
    public  void SetName(String name){_videoName = name;}

    //The video's singer
    private String _videoSinger;

    //Video's Singer getter and setter
    public  String GetSinger(){return _videoSinger;}
    public  void SetSinger(String singer){_videoSinger = singer;}

    //The video's listener count
    private long _listenerCount;

    //Video's listener count getter and setter
    public  String GetListenerCountString(){return String.valueOf(_listenerCount);}
    public  long GetListenerCount(){return _listenerCount;}
    public  void SetListenerCount(long listenerCount){_listenerCount = listenerCount;}

    //The video's thumbnail image
    private String _videoThumbnail;

    //Video's thumbnail getter and setter
    public String GetThumbnail(){return _videoThumbnail;}
    public void SetThumbnail(String image){_videoThumbnail = image;}

    ///
    private int _videoImage;

    ///
    public int GetVideoImage(){return _videoImage;}
    public  void SetVideoImage(int videoImage){_videoImage = videoImage;}

    ///
    public Video(String name, String singer, String thumbnail, long listenerCount, int videoImage)
    {
        this._videoThumbnail = thumbnail;
        this._listenerCount = listenerCount;
        this._videoSinger = singer;
        this._videoName = name;
        this._videoImage = videoImage;
    }


    //Need update
    private String FormatListnerCount(long count)
    {
        if(count < 1000) return String.valueOf(count);
        if(count < 1000000) return (String.valueOf(count / 1000)) + "k";
        return String.valueOf(count);
    }

}

