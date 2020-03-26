package com.example.coronacd;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.internal.ParcelableSparseArray;

import java.util.List;


public class MapFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    GlobalAdapter adapter;
    MapView mapView;
    CoronaViewModel cvm;
    private Marker[] myMarker;
    List<GlobalModel> listGlobal;
    ParcelableSparseArray parcel;
    private GoogleMap map;
    public MapFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        // Inflate the layout for this fragment
        mapView = v.findViewById(R.id.mapView);
        cvm = obtainViewModel(getActivity().getApplication());
        mapView.onCreate(savedInstanceState);

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        LoadCorona();

        return v;
    }

    private void LoadCorona() {
        cvm.getGlobal().observe(getViewLifecycleOwner(), this::viewData);

    }

    private void viewData(List<GlobalModel> list) {
        final Parcelable testing;
        Log.d("Goblok", "awk");
        adapter = new GlobalAdapter(getContext(), list);
        listGlobal = list;
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                if(listGlobal!= null) {
                    for (int i = 0; i < listGlobal.size(); i++) {
                        Attributes attributes = listGlobal.get(i).getAttributes();
                        LatLng temp = new LatLng(attributes.getLat(), attributes.getLong());
                        map.addMarker(new MarkerOptions().position(temp).title(attributes.getCountryRegion()));
                        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                Log.e("asd",marker.getId());
                                String testing = marker.getId();
                                testing = testing.replaceAll("\\D+","");
                                Integer id = Integer.parseInt(testing);
                                Log.e("azz", marker.getTitle());


                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                            if(prev != null)
                                ft.remove(prev);

                            ft.addToBackStack(null);
                            Attributes att = listGlobal.get(id).getAttributes();
                            DialogFragment newFragment = DetailDialogFragment.newInstance(att.getCountryRegion(),att.getActive(),att.getRecovered(),att.getDeaths(),att.getConfirmed());
                            newFragment.show(ft,"dialog");
                                return false;
                            }
                        });

                    }
                }
            }
        });
    }

//                if(listGlobal!=null){
//                for (int i = 0; i < listGlobal.size(); i++) {

//                    String information = attributes.getCountryRegion()+ "\n" + attributes.getConfirmed() + "\n" + attributes.getDeaths() +"\n" + attributes.getRecovered();
//                    LatLng test = new LatLng(listGlobal.get(i).getAttributes().getLat(), listGlobal.get(i).getAttributes().getLong());
//
//                    map.addMarker(new MarkerOptions().position(test).snippet(information).title(information));
//                    map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//                        @Override
//                        public boolean onMarkerClick(Marker marker) {
//                            FragmentTransaction ft = getFragmentManager().beginTransaction();
//                            Fragment prev = getFragmentManager().findFragmentByTag("dialog");
//                            if(prev != null)
//                                ft.remove(prev);
//
//                            ft.addToBackStack(null);
//                            DialogFragment newFragment = DetailDialogFragment.newInstance(attributes.getCountryRegion(),attributes.getActive(),attributes.getRecovered(),attributes.getDeaths());
//                            newFragment.show(ft,"dialog");
//                            return false;
//                        }
//                    });
//                }
//                }



    @NonNull
    private CoronaViewModel obtainViewModel(Application application) {
        ViewModelFactory factory = ViewModelFactory.getInstance(application);
        return factory.create(CoronaViewModel.class);
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


}
