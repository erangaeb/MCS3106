package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mcs.assignment.R;
import com.mcs.assignment.utils.ActivityUtils;

import org.w3c.dom.Text;

/**
 * Created by eranga on 6/29/15.
 */
public class Assignment5aFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout latestPosts;
    private RelativeLayout problems;
    private RelativeLayout newsAndEvents;
    private RelativeLayout donations;
    private RelativeLayout successStories;
    private RelativeLayout findLocation;
    private RelativeLayout aboutUs;
    private RelativeLayout contactUs;

    private TextView latestPostsText;
    private TextView problemsText;
    private TextView newsAndEventsText;
    private TextView donationsText;
    private TextView successStoriesText;
    private TextView findLocationText;
    private TextView aboutUsText;
    private TextView contactUsText;

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

        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");
        initUi();
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        latestPosts = (RelativeLayout) getActivity().findViewById(R.id.latest_post);
        problems = (RelativeLayout) getActivity().findViewById(R.id.problems);
        newsAndEvents = (RelativeLayout) getActivity().findViewById(R.id.news_and_events);
        donations = (RelativeLayout) getActivity().findViewById(R.id.donations);
        successStories = (RelativeLayout) getActivity().findViewById(R.id.success_stories);
        findLocation = (RelativeLayout) getActivity().findViewById(R.id.find_location);
        aboutUs = (RelativeLayout) getActivity().findViewById(R.id.about_us);
        contactUs = (RelativeLayout) getActivity().findViewById(R.id.contact_us);

        latestPosts.setOnClickListener(this);
        problems.setOnClickListener(this);
        newsAndEvents.setOnClickListener(this);
        donations.setOnClickListener(this);
        successStories.setOnClickListener(this);
        findLocation.setOnClickListener(this);
        aboutUs.setOnClickListener(this);
        contactUs.setOnClickListener(this);

        latestPostsText = (TextView) getActivity().findViewById(R.id.latest_post_text);
        problemsText = (TextView) getActivity().findViewById(R.id.problems_text);
        newsAndEventsText = (TextView) getActivity().findViewById(R.id.news_and_events_text);
        donationsText = (TextView) getActivity().findViewById(R.id.donations_text);
        successStoriesText = (TextView) getActivity().findViewById(R.id.success_stories_text);
        findLocationText = (TextView) getActivity().findViewById(R.id.find_location_text);
        aboutUsText = (TextView) getActivity().findViewById(R.id.about_us_text);
        contactUsText = (TextView) getActivity().findViewById(R.id.contact_us_text);

        latestPostsText.setTypeface(typeface, Typeface.BOLD);
        problemsText.setTypeface(typeface, Typeface.BOLD);
        newsAndEventsText.setTypeface(typeface, Typeface.BOLD);
        donationsText.setTypeface(typeface, Typeface.BOLD);
        successStoriesText.setTypeface(typeface, Typeface.BOLD);
        findLocationText.setTypeface(typeface, Typeface.BOLD);
        aboutUsText.setTypeface(typeface, Typeface.BOLD);
        contactUsText.setTypeface(typeface, Typeface.BOLD);
    }

    @Override
    public void onClick(View v) {
        if (v == latestPosts) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected latest posts");
        } else if (v == problems) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected problems");
        } else if (v == newsAndEvents) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected news and events");
        } else if (v == donations) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected donations");
        } else if (v == successStories) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected success stories");
        } else if (v == findLocation) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected find location");
        } else if (v == aboutUs) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected about us");
        } else if (v == contactUs) {
            ActivityUtils.showAlertDialog(this.getActivity(), "You have selected contact us");
        }
    }
}
