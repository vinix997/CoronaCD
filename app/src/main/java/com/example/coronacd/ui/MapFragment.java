package com.example.coronacd.ui;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.coronacd.R;
import com.example.coronacd.model.Attributes;
import com.example.coronacd.model.GlobalModel;
import com.example.coronacd.model.OverallModel;
import com.example.coronacd.viewmodel.CoronaViewModel;
import com.example.coronacd.viewmodel.ViewModelFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MapFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    MapView mapView;
    CoronaViewModel cvm;

    List<GlobalModel> listGlobal;
    TextView tv_Pos;
    TextView tv_Sem;
    TextView tv_Death;

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
        tv_Pos = v.findViewById(R.id.total_positive);
        tv_Sem = v.findViewById(R.id.total_sembuh);
        tv_Death = v.findViewById(R.id.total_meninggal);
        cvm = obtainViewModel(getActivity().getApplication());
        LoadPos();
        LoadSem();
        LoadDeath();
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

    private void LoadPos() {
        cvm.getPositif().observe(getViewLifecycleOwner(), this::viewPos);
    }

    private void LoadSem() {
        cvm.getSembuh().observe(getViewLifecycleOwner(), this::viewSem);
    }

    private void LoadDeath() {
        cvm.getMeninggal().observe(getViewLifecycleOwner(), this::viewDeath);
    }

    private void viewPos(OverallModel list) {
        Log.e("L", list.getValue());
        if (list != null)
            tv_Pos.setText(list.getName() + ": " + list.getValue());
    }

    private void viewSem(OverallModel list) {
        Log.e("Sembuh: ", list.getValue());
        if (list != null)
            tv_Sem.setText(list.getName() + ": " + list.getValue());
    }

    private void viewDeath(OverallModel list) {
        Log.e("Meninggal: ", list.getValue());
        if (list != null)
            tv_Death.setText(list.getName() + ": " + list.getValue());
    }

    private void viewData(List<GlobalModel> list) {
        Log.d("Goblok", "awk");
        listGlobal = list;
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                if (listGlobal != null) {
                    for (int i = 0; i < listGlobal.size(); i++) {
                        Attributes attributes = listGlobal.get(i).getAttributes();
                        LatLng temp = new LatLng(attributes.getLat(), attributes.getLong());
                        map.addMarker(new MarkerOptions().position(temp).title(attributes.getCountryRegion()));
                        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                Log.e("asd", marker.getId());
                                String testing = marker.getId();
                                testing = testing.replaceAll("\\D+", "");
                                Integer id = Integer.parseInt(testing);
                                Log.e("azz", marker.getTitle());


                                FragmentTransaction ft = getFragmentManager().beginTransaction();
                                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                                if (prev != null)
                                    ft.remove(prev);

                                ft.addToBackStack(null);
                                Attributes att = listGlobal.get(id).getAttributes();
                                DialogFragment newFragment = DetailDialogFragment.newInstance(att.getCountryRegion(), att.getActive(), att.getRecovered(), att.getDeaths(), att.getConfirmed());
                                newFragment.show(ft, "dialog");
                                return false;
                            }
                        });

                    }
                }
            }
        });
    }


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
