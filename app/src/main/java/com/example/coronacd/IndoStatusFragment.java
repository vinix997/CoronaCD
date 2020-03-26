package com.example.coronacd;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class IndoStatusFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewAdapter adapter;

    public IndoStatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indo_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewPager);

        tabLayout = view.findViewById(R.id.main_tl);
        setViewPager(viewPager);


    }

    public void setViewPager(ViewPager viewPager) {
        adapter = new ViewAdapter(getChildFragmentManager());
        adapter.addTabFragment(new IndoFragment(), "Indonesia");
        adapter.addTabFragment(new Global(), "Global");
        adapter.addTabFragment(new MapFragment(),"Map");
        viewPager.setAdapter(adapter);
        Log.e("RIP", "RIP");
    }
}
