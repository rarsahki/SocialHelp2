package com.example.android.socialhelp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsRequests>>{
    public boolean isConnected;
    public ProgressBar progressBar;
    public static final String URL = "https://newsapi.org/v1/articles?source=the-hindu&sortBy=latest&apiKey=1137663277724f7ebffb67f14cc1d8fb";
    public CustomArrayAdapterNews customArrayAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ConnectivityManager connectivityManager = (ConnectivityManager) NewsActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        ListView listView = (ListView) findViewById(R.id.activity_news);
        if(isConnected){
            customArrayAdapter1 = new CustomArrayAdapterNews(this, new ArrayList<NewsRequests>());
            listView.setAdapter(customArrayAdapter1);
            getSupportLoaderManager().initLoader(0, null, this).forceLoad();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    NewsRequests newsRequests = customArrayAdapter1.getItem(position);
                    Bundle bundle = new Bundle();
                    bundle.putString("URL",newsRequests.getmUrl());
                    //Uri uri = Uri.parse(newsRequests.getmUrl());
                    Intent intent = new Intent(NewsActivity.this,wb.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });
        }else{
            progressBar = (ProgressBar)findViewById(R.id.progress);
            progressBar.setVisibility(View.INVISIBLE);
            TextView textView = (TextView) findViewById(R.id.no_internet);
            textView.setText("NO INTERNET CONNECTION");
        }
    }

    @Override
    public Loader<List<NewsRequests>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(this,URL);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsRequests>> loader, List<NewsRequests> data) {
        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
        customArrayAdapter1.clear();
        if(data != null && !data.isEmpty()){
            customArrayAdapter1.addAll(data);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<NewsRequests>> loader) {
            customArrayAdapter1.clear();
    }
}
