package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mcs.assignment.R;

/**
 * Created by eranga on 6/29/15.
 */
public class Assignment5aFragment extends Fragment implements View.OnClickListener {

    // use custom font here
    private Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment5a, container, false);

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

    private void initUi() {
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");
    }

    @Override
    public void onClick(View v) {
    }
}
