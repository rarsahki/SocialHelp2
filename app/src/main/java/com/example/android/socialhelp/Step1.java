package com.example.android.socialhelp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 19-07-2018.
 */

public class Step1 {
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("title")
    @Expose
    private String title;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
