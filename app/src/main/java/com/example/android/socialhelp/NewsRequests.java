package com.example.android.socialhelp;

import android.graphics.Bitmap;

/**
 * Created by User on 07-07-2017.
 */

public class NewsRequests {
    private String mTitle;
    private String mDescription;
    private String mUrl;
    private String mUrlToImage;
    private Bitmap mBitmap;

    public NewsRequests(String title, String description, String url, String urlToImage, Bitmap bitmap){
        mTitle = title;
        mDescription = description;
        mUrl = url;
        mUrlToImage = urlToImage;
        mBitmap = bitmap;
    }
    public String getmTitle(){
        return mTitle;
    }
    public Bitmap getmBitmap(){return mBitmap;}
    public String getmDescription(){
        return mDescription;
    }public String getmUrl(){
        return mUrl;
    }public String getmUrlToImage(){
        return mUrlToImage;
    }
}
