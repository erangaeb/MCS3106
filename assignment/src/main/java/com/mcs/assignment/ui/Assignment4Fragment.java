package com.mcs.assignment.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mcs.assignment.R;

/**
 * Switch board fragment content
 */
public class Assignment4Fragment extends Fragment implements View.OnClickListener {

    // inputs fields
    private EditText firstNumber;
    private EditText secondNumber;
    private EditText answer;

    // buttons
    private RelativeLayout add;
    private RelativeLayout subtract;

    // set custom font
    Typeface typefaceThin;
    Typeface typefaceBlack;


    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment4, container, false);

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

    /**
     * Initialize UI components
     */
    private void initUi() {
        typefaceThin = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/vegur_2.otf");
        typefaceBlack = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/Roboto-Black.ttf");

        firstNumber = (EditText) getActivity().findViewById(R.id.assignment4_first_number);
        secondNumber = (EditText) getActivity().findViewById(R.id.assignment4_second_number);
        answer = (EditText) getActivity().findViewById(R.id.assignment4_answer);

        add = (RelativeLayout) getActivity().findViewById(R.id.assignment4_add);
        add.setOnClickListener(this);
        subtract = (RelativeLayout) getActivity().findViewById(R.id.assignment4_subtract);
        add.setOnClickListener(this);
    }

    private void add() {
        String first = firstNumber.getText().toString().trim();
        String second = secondNumber.getText().toString().trim();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this.getActivity(), "Invalid input", Toast.LENGTH_LONG).show();
        } else {
            answer.setText(Double.toString(Double.parseDouble(first) + Double.parseDouble(second)));
        }
    }

    private void subtract() {
        String first = firstNumber.getText().toString().trim();
        String second = secondNumber.getText().toString().trim();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this.getActivity(), "Invalid input", Toast.LENGTH_LONG).show();
        } else {
            answer.setText(Double.toString(Double.parseDouble(first) - Double.parseDouble(second)));
        }
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


    @Override
    public void onClick(View v) {
        if (v == add) {
            add();
            displayAlertDialog("Option");
        } else if (v == subtract) {
            subtract();
            displayAlertDialog("Option");
        }
    }

    private void displayAlertDialog(String message) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this.getActivity());
        builder1.setMessage("Write your message here.");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
