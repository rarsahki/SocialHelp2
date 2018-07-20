package com.example.android.socialhelp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by User on 08-07-2017.
 */

public class CustomArrayAdapter2 extends ArrayAdapter<Requests> {
    public CustomArrayAdapter2(Context context, List<Requests> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.stepimage2,parent,false);
        }
        Requests requests = getItem(position);
        ImageView imageView = (ImageView) listView.findViewById(R.id.step_image);
        if(requests.getmBitmap() != null){
            imageView.setImageBitmap(requests.getmBitmap());
        }else{
            imageView.setImageResource(requests.getmImageId());
        }
        return listView;
    }
}
