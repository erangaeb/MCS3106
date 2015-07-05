package com.mcs.assignment.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    private TextView browseText;
    private RelativeLayout browseLayout;
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

        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");
        initUi();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        browseText = (TextView) getActivity().findViewById(R.id.assignment8_browse_text);
        browseText.setTypeface(typeface, Typeface.BOLD);

        browseLayout = (RelativeLayout) getActivity().findViewById(R.id.assignment8_browse);
        browseLayout.setOnClickListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FILE_CHOOSER) {
            if (data != null) {
                String filePath = data.getData().getPath();
                getUrlsFromSelectedFile(filePath);
            }
        }
    }

    /**
     * Show file chooser options available
     */
    private void browseFiles() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("*/*");
        startActivityForResult(i, REQUEST_FILE_CHOOSER);
    }

    /**
     * Identifies urls stored in selected file
     *
     * @param filePath selected file path
     */
    private void getUrlsFromSelectedFile(String filePath) {
        urlList = new ArrayList();

        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                urlList.add(line);
            }

            showUrlList();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Launch UrlListActivity with selected file content
     */
    private void showUrlList() {
        Intent intent = new Intent(this.getActivity(), UrlListActivity.class);
        intent.putStringArrayListExtra("url_list", (ArrayList<String>) urlList);

        this.getActivity().startActivity(intent);
        this.getActivity().overridePendingTransition(R.anim.right_in, R.anim.stay_in);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        if (v == browseLayout) {
            browseFiles();
        }
    }

}
