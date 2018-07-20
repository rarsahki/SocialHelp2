package com.example.android.socialhelp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 20-07-2018.
 */

public class Appmodel {
    @SerializedName("Whapp")
    @Expose
    private List<Whapp> whapp = null;

    public List<Whapp> getWhapp() {
        return whapp;
    }

    public void setWhapp(List<Whapp> whapp) {
        this.whapp = whapp;
    }
}
