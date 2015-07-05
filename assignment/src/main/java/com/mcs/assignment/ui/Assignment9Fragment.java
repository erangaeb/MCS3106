package com.mcs.assignment.ui;

import android.app.SearchManager;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mcs.assignment.R;
import com.mcs.assignment.utils.ActivityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Display power usage summary
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class Assignment9Fragment extends Fragment implements SearchView.OnQueryTextListener {

    private GoogleMap googleMap;
    private MapView mapView;

    private SearchView searchView;
    private MenuItem searchMenuItem;

    private List<LatLng> locationList;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_map, container, false);
        setHasOptionsMenu(true);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) root.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        googleMap = mapView.getMap();
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        MapsInitializer.initialize(this.getActivity());

        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager) this.getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getActivity().getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onResume() {
        super.onResume();

        mapView.onResume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        // close search view
        searchView.onActionViewCollapsed();
        getActivity().supportInvalidateOptionsMenu();
        ActivityUtils.hideSoftKeyboard(this.getActivity());

        showLocation(query.trim());

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    /**
     * Search given city and display in the map
     *
     * @param location city
     */
    private void showLocation(String location) {
        if (Geocoder.isPresent()) {
            try {
                Geocoder geocoder = new Geocoder(this.getActivity());
                List<Address> addresses = geocoder.getFromLocationName(location, 5);

                // A list to save the coordinates if they are available
                locationList = new ArrayList(addresses.size());
                for (Address address : addresses) {
                    if (address.hasLatitude() && address.hasLongitude()) {
                        locationList.add(new LatLng(address.getLatitude(), address.getLongitude()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // display location/city
        LatLng currentCoordinates = locationList.get(0);
        googleMap.addMarker(new MarkerOptions().position(currentCoordinates).title(location).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluedot)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentCoordinates, 10));
    }

}
