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
    TextView name;
    TextView indexNo;
    TextView email;

    EditText nameEditText;
    EditText indexNoEditText;
    EditText emailEditText;

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

        name = (TextView) getActivity().findViewById(R.id.assignment1_name_label);
        indexNo = (TextView) getActivity().findViewById(R.id.assignment1_index_no_label);
        email = (TextView) getActivity().findViewById(R.id.assignment1_email_label);

        nameEditText = (EditText) getActivity().findViewById(R.id.assignment1_name_text);
        indexNoEditText = (EditText) getActivity().findViewById(R.id.assignment1_index_no_text);
        emailEditText = (EditText) getActivity().findViewById(R.id.assignment1_email_text);

        name.setTypeface(typeface, Typeface.BOLD);
        indexNo.setTypeface(typeface, Typeface.BOLD);
        email.setTypeface(typeface, Typeface.BOLD);

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
