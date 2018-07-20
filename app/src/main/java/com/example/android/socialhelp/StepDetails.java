package com.example.android.socialhelp;

import android.support.v4.app.Fragment;

/**
 * Created by User on 19-07-2018.
 */

public class StepDetails {
    public String title1, imgurl1;
    public StepFragment fragment11;
    public int num1;
    public StepDetails(StepFragment fragment){
        fragment11 = fragment;
    }

    public int getNum1() {
        return num1;
    }

    public Fragment getFragment11() {
        return fragment11;
    }

    public String getImgurl1() {
        return imgurl1;
    }

    public String getTitle1() {
        return title1;
    }
}
