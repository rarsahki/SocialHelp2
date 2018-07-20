package com.example.android.socialhelp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 07-07-2017.
 */

public class CustomArrayAdapterNews extends ArrayAdapter<NewsRequests>{
    public CustomArrayAdapterNews(Context context, List<NewsRequests> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.stepimage,parent,false);
        }
        NewsRequests newsRequests = getItem(position);
        ImageView imageView = (ImageView) listView.findViewById(R.id.image);
        imageView.setImageBitmap(newsRequests.getmBitmap());
        TextView textView1 = (TextView) listView.findViewById(R.id.title);
        textView1.setText(newsRequests.getmTitle());
        TextView textView2 = (TextView) listView.findViewById(R.id.description);
        textView2.setText(newsRequests.getmDescription());
        return listView;
    }
}
