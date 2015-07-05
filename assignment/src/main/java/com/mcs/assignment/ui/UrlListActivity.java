package com.mcs.assignment.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mcs.assignment.R;
import com.mcs.assignment.adapters.UrlListAdapter;

import java.util.ArrayList;

public class UrlListActivity extends Activity {

    // use to populate list
    private UrlListAdapter adapter;
    private ListView urlListView;
    private ViewStub emptyView;

    private ArrayList<String> urlList;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_url_list);

        if (getIntent().getExtras() != null) {
            urlList = getIntent().getExtras().getStringArrayList("url_list");
        }

        initUi();
        initUrlList();
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        urlListView = (ListView) findViewById(R.id.url_list);

        // add header and footer for list
        View headerView = View.inflate(this, R.layout.list_header, null);
        View footerView = View.inflate(this, R.layout.list_header, null);
        urlListView.addHeaderView(headerView);
        urlListView.addFooterView(footerView);
    }

    /**
     * Create url list
     */
    private void initUrlList() {
        adapter = new UrlListAdapter(this, urlList);
        urlListView.setAdapter(adapter);

        // set up click listener
        urlListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position <= urlList.size()) {
                    launchWebView((String) adapter.getItem(position - 1));
                }
            }
        });
    }

    /**
     * Navigate to WebActivity activity form here
     */
    private void launchWebView(String url) {
        // pass selected user and sensor to share activity
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", url);
        this.startActivity(intent);
        this.overridePendingTransition(R.anim.bottom_in, R.anim.stay_in);
    }

}
