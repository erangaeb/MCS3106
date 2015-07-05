package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    private LinearLayout backgroundLinerLayout;
    private TextView dateTextView;
    private TextView timeTextView;
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

        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");

        initUi();
        showDateAndTime();
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        backgroundLinerLayout = (LinearLayout) getActivity().findViewById(R.id.assignment2_top_layout);
        backgroundLinerLayout.setOnClickListener(this);

        dateTextView = (TextView) getActivity().findViewById(R.id.assignment2_date_label);
        timeTextView = (TextView) getActivity().findViewById(R.id.assignment2_time_label);

        dateTextView.setTypeface(typeface, Typeface.BOLD);
        timeTextView.setTypeface(typeface, Typeface.BOLD);

        dateEditText = (EditText) getActivity().findViewById(R.id.assignment2_date_text);
        timeEditText = (EditText) getActivity().findViewById(R.id.assignment2_time_text);

        dateEditText.setTypeface(typeface, Typeface.NORMAL);
        timeEditText.setTypeface(typeface, Typeface.NORMAL);
    }

    /**
     * Display date and time on text fields
     */
    private void showDateAndTime() {
        dateEditText.setText(getDate());
        timeEditText.setText(getTime());
    }

    /**
     * Get today's date in format (dd-MM-yyyy)
     * @return date string
     */
    private String getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return dateFormat.format(calendar.getTime());
    }

    /**
     * Get current time in form (hh:mm a)
     * @return time string
     */
    private String getTime() {
        Calendar calendar = Calendar.getInstance();
        Date currentLocalTime = calendar.getTime();
        DateFormat date = new SimpleDateFormat("hh:mm:ss a");

        return date.format(currentLocalTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        if (v == backgroundLinerLayout) {
            showDateAndTime();
        }
    }
}
