package com.hospitalsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hospitalsystem.databinding.ActivityMapsBinding;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(4.001620681287662, 102.1400710256236);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Hospital Kajang")
                .position(new LatLng(2.9931321386486704, 101.79286725423259))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Kangar")
                .position(new LatLng(6.443474024755914, 100.19126910025813))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Raja Perempuan Zainab II, Kota Bharu")
                .position(new LatLng(6.202518280248498, 102.25313349308483))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Tanah Merah")
                .position(new LatLng(5.850167779989616, 102.14601680072134))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Machang")
                .position(new LatLng(5.8255767439198385, 102.23116083824104))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Kuala Lumpur")
                .position(new LatLng(3.176414595422977, 101.70247605589678))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Machang")
                .position(new LatLng(5.8255767439198385, 102.23116083824104))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Ampang")
                .position(new LatLng(3.1311634844646354, 101.76358745028604))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Sultan Abdul Halim,Sungai Petani")
                .position(new LatLng(3.1311634844646354, 101.76358745028604))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Alor Setar")
                .position(new LatLng(6.142013306091082, 100.37097549667568))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Pulau Pinang")
                .position(new LatLng(5.416825709960067, 100.31103836783751))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Raja Permaisuri Bainun, Ipoh")
                .position(new LatLng(4.606259852566788, 101.0902030280264))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Sungai Siput Perak")
                .position(new LatLng(4.828090367255377, 101.05708578318212))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Besar Pahang")
                .position(new LatLng(3.8355133029694826, 103.30494248318124))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Sultanah Nur Zahirah, Terengganu")
                .position(new LatLng(5.324795964381382, 103.14977508132803))
                .snippet("Open during MCO: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Besut")
                .position(new LatLng(5.729789073894023, 102.49253771016538))
                .snippet("Open during MCO: 24 hours")
        );

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));


        for(MarkerOptions mark : markerOptions){
            mMap.addMarker(mark);
        }

        enableMyLocation();


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,8));
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this,perms,200);
        }
    }
}