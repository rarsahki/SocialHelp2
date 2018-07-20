package com.example.android.socialhelp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StepsActivity extends AppCompatActivity {
    TextView textView;
    public static int i;
    public static Help help;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        final Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("http://api.jsonbin.io").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        fetchData gotapi = retrofit.create(fetchData.class);
        Bundle bundle = getIntent().getExtras();
        Log.v("URL",bundle.getString("url").toString());
        Call<Help> call = gotapi.getTitle(bundle.getString("url"));
        call.enqueue(new Callback<Help>() {
            @Override
            public void onResponse(Call<Help> call, Response<Help> response) {
                i = response.body().getStepnumbers();
                help = response.body();
                VerticalViewPager viewPager = (VerticalViewPager) findViewById(R.id.viewPager);
                FragmentAdapter fragmentAdapter = new FragmentAdapter(StepsActivity.this, getSupportFragmentManager());
                viewPager.setAdapter(fragmentAdapter);
            }
            @Override
            public void onFailure(Call<Help> call, Throwable t) {

            }
        });
    }
}
