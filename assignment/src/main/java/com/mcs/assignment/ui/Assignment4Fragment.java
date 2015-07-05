package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mcs.assignment.R;

/**
 * Assignment4 fragment class
 *
 * @author eranga herath(erangae@gmail.com)
 */
public class Assignment4Fragment extends Fragment implements View.OnClickListener {

    // input field labels
    private TextView firstNumberLabel;
    private TextView secondNumberLabel;
    private TextView answerLabel;

    // inputs fields
    private EditText firstNumber;
    private EditText secondNumber;
    private EditText answer;

    // button texts
    private TextView addText;
    private TextView subtractText;

    // buttons
    private RelativeLayout add;
    private RelativeLayout subtract;

    // set custom font
    Typeface typeface;


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

        typeface = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/vegur_2.otf");

        initUi();
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        firstNumberLabel = (TextView) getActivity().findViewById(R.id.assignment4_first_number_label);
        secondNumberLabel = (TextView) getActivity().findViewById(R.id.assignment4_second_number_label);
        answerLabel = (TextView) getActivity().findViewById(R.id.assignment4_answer_label);

        firstNumberLabel.setTypeface(typeface, Typeface.BOLD);
        secondNumberLabel.setTypeface(typeface, Typeface.BOLD);
        answerLabel.setTypeface(typeface, Typeface.BOLD);

        firstNumber = (EditText) getActivity().findViewById(R.id.assignment4_first_number);
        secondNumber = (EditText) getActivity().findViewById(R.id.assignment4_second_number);
        answer = (EditText) getActivity().findViewById(R.id.assignment4_answer);

        firstNumber.setTypeface(typeface, Typeface.NORMAL);
        secondNumber.setTypeface(typeface, Typeface.NORMAL);
        answer.setTypeface(typeface, Typeface.NORMAL);

        addText = (TextView) getActivity().findViewById(R.id.assignment4_add_button_text);
        subtractText = (TextView) getActivity().findViewById(R.id.assignment4_subtract_button_text);

        addText.setTypeface(typeface, Typeface.BOLD);
        subtractText.setTypeface(typeface, Typeface.BOLD);

        add = (RelativeLayout) getActivity().findViewById(R.id.assignment4_add);
        subtract = (RelativeLayout) getActivity().findViewById(R.id.assignment4_subtract);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
    }

    /**
     * Add two numbers and display in the answer field
     */
    private void add() {
        String first = firstNumber.getText().toString().trim();
        String second = secondNumber.getText().toString().trim();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this.getActivity(), "Invalid input", Toast.LENGTH_LONG).show();
        } else {
            answer.setText(Double.toString(Double.parseDouble(first) + Double.parseDouble(second)));
        }
    }

    /**
     * Subtract two numbers and display in the answer field
     */
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
    @Override
    public void onClick(View v) {
        if (v == add) {
            add();
        } else if (v == subtract) {
            subtract();
        }
    }


}
