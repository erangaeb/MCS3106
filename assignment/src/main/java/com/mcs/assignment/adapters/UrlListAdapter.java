package com.mcs.assignment.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mcs.assignment.R;
import com.mcs.assignment.ui.UrlListActivity;

import java.util.ArrayList;


/**
 * Adapter class to display friend/user list
 *
 * @author erangaeb@gmail.com (eranga herath)
 */
public class UrlListAdapter extends BaseAdapter {

    private UrlListActivity urlListActivity;
    private ArrayList<String> urlList;

    // set custom font
    private Typeface typeface;

    /**
     * Initialize context variables
     */
    public UrlListAdapter(UrlListActivity activity, ArrayList<String> urlList) {
        this.urlListActivity = activity;
        this.urlList = urlList;

        typeface = Typeface.createFromAsset(urlListActivity.getAssets(), "fonts/vegur_2.otf");
    }

    /**
     * Get size of user list
     *
     * @return userList size
     */
    @Override
    public int getCount() {
        return urlList.size();
    }

    /**
     * Get specific item from user list
     *
     * @param i item index
     * @return list item
     */
    @Override
    public Object getItem(int i) {
        return urlList.get(i);
    }

    /**
     * Get user list item id
     *
     * @param i item index
     * @return current item id
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * Create list row view
     *
     * @param i         index
     * @param view      current list item view
     * @param viewGroup parent
     * @return view
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // A ViewHolder keeps references to children views to avoid unnecessary calls
        // to findViewById() on each row.
        final ViewHolder holder;

        final String url = (String) getItem(i);

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) urlListActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout_url_list_row, viewGroup, false);

            holder = new ViewHolder();
            holder.url = (TextView) view.findViewById(R.id.url);
            holder.url.setTypeface(typeface, Typeface.BOLD);

            view.setTag(holder);
        } else {
            // get view holder back
            holder = (ViewHolder) view.getTag();
        }

        // bind text with view holder content view for efficient use
        holder.url.setText(url);
        view.setBackgroundResource(R.drawable.url_list_selector);

        return view;
    }

    /**
     * Keep reference to children view to avoid unnecessary calls
     */
    static class ViewHolder {
        TextView url;
    }
}

