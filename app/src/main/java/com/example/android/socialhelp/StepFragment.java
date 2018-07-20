package com.example.android.socialhelp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by User on 29-06-2017.
 */

public class StepFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.steplayout,container,false);
        TextView textView = (TextView) rootView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.img);
        textView.setText(getArguments().getString("Title"));
        Picasso.with(getContext()).load(getArguments().getString("ImageUrl")).fit().into(imageView);
        Log.v("Fragment","Created");
        return rootView;
    }
}
