package com.example.android.socialhelp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 19-07-2018.
 */

public class Help {

    @SerializedName("steps")
    @Expose
    private List<Step1> steps = null;
    @SerializedName("stepnumbers")
    @Expose
    private Integer stepnumbers;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("id")
    @Expose
    private String id;

    public List<Step1> getSteps() {
        return steps;
    }

    public void setSteps(List<Step1> steps) {
        this.steps = steps;
    }

    public Integer getStepnumbers() {
        return stepnumbers;
    }

    public void setStepnumbers(Integer stepnumbers) {
        this.stepnumbers = stepnumbers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
