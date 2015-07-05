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

import com.mcs.assignment.R;
import com.mcs.assignment.utils.ActivityUtils;

/**
 * Created by eranga on 6/29/15.
 */
public class Assignment5bFragment extends Fragment implements View.OnClickListener {

    private static final String USERNAME = "eranga";
    private static final String PASSWORD = "1234";

    private EditText usernameEditText;
    private EditText passwordEditText;

    private TextView signInTextView;
    private TextView signUpTextView;

    private RelativeLayout signInRelativeLayout;
    private RelativeLayout signUpRelativeLayout;

    // use custom font here
    private Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment5b, container, false);

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
        usernameEditText = (EditText) getActivity().findViewById(R.id.assignment5b_username);
        passwordEditText = (EditText) getActivity().findViewById(R.id.assignment5b_password);

        usernameEditText.setTypeface(typeface, Typeface.NORMAL);
        passwordEditText.setTypeface(typeface, Typeface.NORMAL);

        signInTextView = (TextView) getActivity().findViewById(R.id.assignment5b_sign_in_text);
        signUpTextView = (TextView) getActivity().findViewById(R.id.assignment5b_sign_up_text);

        signInTextView.setTypeface(typeface, Typeface.BOLD);
        signUpTextView.setTypeface(typeface, Typeface.BOLD);

        signInRelativeLayout = (RelativeLayout) getActivity().findViewById(R.id.assignment5b_sign_in);
        signUpRelativeLayout = (RelativeLayout) getActivity().findViewById(R.id.assignment5b_sign_up);

        signInRelativeLayout.setOnClickListener(this);
        signUpRelativeLayout.setOnClickListener(this);
    }

    /**
     * Sign in user
     */
    private void doSignIn() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            ActivityUtils.showAlertDialog(this.getActivity(), "Error", "Invalid credentials");
        } else if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            ActivityUtils.showAlertDialog(this.getActivity(), "Successful", "Login success");
        } else {
            ActivityUtils.showAlertDialog(this.getActivity(), "Error", "Login fail");
        }

    }

    /**
     * Sign up user
     */
    private void doSignUp() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            ActivityUtils.showAlertDialog(this.getActivity(), "Error", "Invalid credentials");
        } else {
            ActivityUtils.showAlertDialog(this.getActivity(), "Successful", "Successfully signed up");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        if (v == signInRelativeLayout) {
            doSignIn();
        } else if (v == signUpRelativeLayout) {
            doSignUp();
        }
    }
}
