package com.example.coronacd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity /*implements OnMapReadyCallback*/ {
//    GoogleMap map;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fl, new IndoStatusFragment());
        ft.commit();


    }


//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        map =  googleMap;
//        LatLng test = new LatLng(19.169257, 73.341601);
//        map.addMarker(new MarkerOptions().position(test)).setTitle("India");
//
//        map.moveCamera(CameraUpdateFactory.newLatLng(test));
//        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//
//                return false;
//            }
//        });
//    }
}
