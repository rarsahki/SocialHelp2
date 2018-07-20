package com.example.android.socialhelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class wb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wb);
        WebView webview = new WebView(wb.this);
        setContentView(webview);
        Bundle bundle = getIntent().getExtras();
        webview.loadUrl(bundle.getString("URL"));
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setAppCacheEnabled(true);
    }
}
