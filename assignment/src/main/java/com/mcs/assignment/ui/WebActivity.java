package com.mcs.assignment.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.mcs.assignment.R;

public class WebActivity extends Activity {

    private WebView webView;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);

        initUi();
        loadUrl();
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        webView = (WebView) findViewById(R.id.webview);
    }

    /**
     * Load url in web view
     */
    private void loadUrl() {
        if (getIntent().getExtras() != null) {
            String url = getIntent().getExtras().getString("url");
            webView.loadUrl(url);
        }
    }

}
