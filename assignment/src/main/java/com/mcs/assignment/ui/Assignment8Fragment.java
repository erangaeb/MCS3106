package com.mcs.assignment.ui;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.mcs.assignment.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Display power usage summary
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class Assignment8Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    RelativeLayout browseButton;

    // use custom font here
    private Typeface typeface;
    private List<String> urlList;


    private static final int REQUEST_FILE_CHOOSER = 2;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment8, container, false);

        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initUi();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FILE_CHOOSER) {
            String filePath = data.getData().getPath();

            try {
                File file = new File(filePath);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                urlList = new ArrayList<String>();
                while ((line = br.readLine()) != null) {
                    urlList.add(line);
                }

                // load url list
                loadUrlList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initUi() {
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");

        browseButton = (RelativeLayout) getActivity().findViewById(R.id.assignment1_camera);
        browseButton.setOnClickListener(this);
    }

    private void openFolder() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("*/*");
        startActivityForResult(i, REQUEST_FILE_CHOOSER);
    }

    private void loadUrlList() {
        Intent intent = new Intent(this.getActivity(), UrlListActivity.class);
        intent.putStringArrayListExtra("url_list", (ArrayList<String>)urlList);

        this.getActivity().startActivity(intent);
        this.getActivity().overridePendingTransition(R.anim.right_in, R.anim.stay_in);
    }

    @Override
    public void onClick(View v) {
        if (v == browseButton) {
            openFolder();
        }
    }


}
