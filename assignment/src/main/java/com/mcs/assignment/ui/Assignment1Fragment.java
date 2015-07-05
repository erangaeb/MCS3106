package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mcs.assignment.R;

/**
 * Fragment to display today power consumption
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class Assignment1Fragment extends android.support.v4.app.Fragment {

    // UI Components
    private TextView nameTextView;
    private TextView indexNoTextView;
    private TextView emailTextView;

    private EditText nameEditText;
    private EditText indexNoEditText;
    private EditText emailEditText;

    // use custom font here
    private Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment1, container, false);

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
     * Initialize UI components
     */
    private void initUi() {

        nameTextView = (TextView) getActivity().findViewById(R.id.assignment1_name_label);
        indexNoTextView = (TextView) getActivity().findViewById(R.id.assignment1_index_no_label);
        emailTextView = (TextView) getActivity().findViewById(R.id.assignment1_email_label);

        nameTextView.setTypeface(typeface, Typeface.BOLD);
        indexNoTextView.setTypeface(typeface, Typeface.BOLD);
        emailTextView.setTypeface(typeface, Typeface.BOLD);

        nameEditText = (EditText) getActivity().findViewById(R.id.assignment1_name_text);
        indexNoEditText = (EditText) getActivity().findViewById(R.id.assignment1_index_no_text);
        emailEditText = (EditText) getActivity().findViewById(R.id.assignment1_email_text);

        nameEditText.setTypeface(typeface, Typeface.NORMAL);
        indexNoEditText.setTypeface(typeface, Typeface.NORMAL);
        emailEditText.setTypeface(typeface, Typeface.NORMAL);

    }

    /**
     * {@inheritDoc}
     */
    public void onResume() {
        super.onResume();
    }

    /**
     * {@inheritDoc}
     */
    public void onPause() {
        super.onPause();
    }

}
