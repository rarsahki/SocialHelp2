package com.example.android.socialhelp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by User on 28-06-2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    public Context context1;
    public static ArrayList<StepDetails> arrayList;
    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        context1 = context;
    }

    @Override
    public Fragment getItem(int position) {
        arrayList = new ArrayList<>();
        for(int j=0;j<StepsActivity.i;j++){
            StepFragment stepFragment = new StepFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Title",StepsActivity.help.getSteps().get(j).getTitle());
            bundle.putString("ImageUrl",StepsActivity.help.getSteps().get(j).getImageUrl());
            stepFragment.setArguments(bundle);
            arrayList.add(new StepDetails(stepFragment));
            Log.d("test","Created = "+j);
        }
        return arrayList.get(position).getFragment11();
    }


    @Override
    public int getCount() {
        return StepsActivity.i;
    }
}
