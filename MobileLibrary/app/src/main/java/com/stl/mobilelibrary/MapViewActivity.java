package com.stl.mobilelibrary;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

/**
 * View a specific location on a map
 */
public class MapViewActivity extends AppCompatActivity {

    /**
     * Inflate the MapboxFragment with the location specified in the
     * intent used to start the activity
     * @param savedInstanceState: the saved instance state
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapview);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        double latitude = getIntent().getExtras().getDouble("latitude");
        double longitude = getIntent().getExtras().getDouble("longitude");
        MapboxFragment mapboxFragment = MapboxFragment.newInstance(latitude, longitude);
        ft.replace(R.id.mapboxFragmentPlaceholder, mapboxFragment);
        ft.commit();
    }
}
