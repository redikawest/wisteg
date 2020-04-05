package com.example.wisteg;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap peta;
    String Lat,Lng;
    Double La, Ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        peta = googleMap;

        //LatLng lokasi = new LatLng(-6.7521643, 111.map.xml0316679);
        Intent mIntent = getIntent();
        Lat = mIntent.getStringExtra("Lat");
        Lng = mIntent.getStringExtra("Lng");
        LatLng lokasi = new LatLng(Double.parseDouble(Lat), Double.parseDouble(Lng));

        peta.addMarker(new MarkerOptions().position(lokasi).title("lokasiku"));
        peta.moveCamera(CameraUpdateFactory.newLatLng(lokasi));
        peta.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 15.0f));
        peta.getUiSettings().setZoomControlsEnabled(true);
        peta.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}
