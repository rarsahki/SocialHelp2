package com.example.android.socialhelp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 29-06-2017.
 */

public class CustomArrayAdapter extends ArrayAdapter<Requests> {

    public CustomArrayAdapter(Context context,List<Requests> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.listviewlayout,parent,false);
        }
        Requests requests = getItem(position);
        TextView textView = (TextView) listItemView.findViewById(R.id.text);
        textView.setText(requests.getmTitle());
        TextView textView1 =(TextView) listItemView.findViewById(R.id.image);
        GradientDrawable gradientDrawable = (GradientDrawable) textView1.getBackground();
        int color = getStepColor(requests.getmStep());
        gradientDrawable.setColor(color);
        textView1.setText(requests.getmSteps()+"");
        return listItemView;
    }
    public int getStepColor(int stepValue){
        int color = 0;
        if(stepValue <= 3)
            color = ContextCompat.getColor(getContext(),R.color.salmon);
        else if(stepValue >3 && stepValue <=5)
            color = ContextCompat.getColor(getContext(),android.R.color.holo_red_light);
        else if(stepValue >5 && stepValue <=7)
            color = ContextCompat.getColor(getContext(),R.color.indianRed);
        else if(stepValue >7 && stepValue <=10)
            color = ContextCompat.getColor(getContext(),android.R.color.holo_red_dark);

        return color;
    }

}
