package com.example.android.socialhelp;

import android.graphics.Bitmap;

/**
 * Created by User on 29-06-2017.
 */

public class Requests {
    private String mRequest;
    private int mStep;
    private int mImageId;
    private Bitmap mBitmap;
    private String mTitle;
    private String murl;
    private int mSteps;

    public Requests(String Title, String url, int Steps){
        mTitle = Title;
        murl = url;
        mSteps = Steps;
    }

    public int getmSteps() {
        return mSteps;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getMurl() {
        return murl;
    }

    public Requests(String request, int step){
        mRequest = request;
        mStep = step;
    }
    public Requests(int imageId){
        mImageId = imageId;
    }

    public Requests(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public String getmRequest(){
        return mRequest;
    }
    public int getmStep(){
        return mStep;
    }
    public int getmImageId(){ return mImageId; }
    public Bitmap getmBitmap(){return mBitmap;}
}
