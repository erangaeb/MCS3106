package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.mcs.assignment.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Display power usage summary
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class Assignment2Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private LinearLayout topLayout;
    private EditText dateEditText;
    private EditText timeEditText;

    // use custom font here
    private Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment2, container, false);

        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initUi();
        showDateAndTime();
    }

    private void initUi() {
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");

        topLayout = (LinearLayout) getActivity().findViewById(R.id.assignment2_top_layout);
        topLayout.setOnClickListener(this);
        dateEditText = (EditText) getActivity().findViewById(R.id.assignment2_date_text);
        timeEditText = (EditText) getActivity().findViewById(R.id.assignment2_time_text);
    }

    /**
     * Display date and time on text fields
     */
    private void showDateAndTime() {
        dateEditText.setText(getDate());
        timeEditText.setText(getTime());
    }

    private String getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        return dateFormat.format(calendar.getTime());
    }

    private String getTime() {
        Calendar calendar = Calendar.getInstance();
        Date currentLocalTime = calendar.getTime();
        DateFormat date = new SimpleDateFormat("hh:mm a");

        return date.format(currentLocalTime);
    }

    @Override
    public void onClick(View v) {
        if (v == topLayout) {
            showDateAndTime();
        }
    }
}
