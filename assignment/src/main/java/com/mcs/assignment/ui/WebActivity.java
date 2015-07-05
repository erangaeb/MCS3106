package com.mcs.assignment.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.mcs.assignment.R;

public class WebActivity extends Activity {

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);

        if (getIntent().getExtras() != null) {
            url = getIntent().getExtras().getString("url");
        }
    }

    private void initUi(String url) {
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.example.com");
    }

}
