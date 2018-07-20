package com.example.android.socialhelp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by User on 07-07-2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<NewsRequests>> {
    private String mUrl;
    public NewsLoader(Context context) {
        super(context);
    }
    public NewsLoader(Context context, String url){
        super(context);
        mUrl = url;
    }
    public void onStartLoading(){
        forceLoad();
    }

    @Override
    public List<NewsRequests> loadInBackground() {
        if(mUrl == null)
            return null;
        List<NewsRequests> requestses = QueryUtils.fetchData(mUrl);
        return  requestses;
    }
}
