package com.example.coronacd;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Global extends Fragment {
    GlobalAdapter adapter;
    RecyclerView rv;
    CoronaViewModel cvm;
    ProgressBar progressBar;
    public Global() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_global, container, false);
        rv = v.findViewById(R.id.rv_global);
        cvm = obtainViewModel(getActivity().getApplication());
        progressBar = v.findViewById(R.id.progressBar_Global);
        showLoading(true);
        LoadDetail();
        // Inflate the layout for this fragment
        return v;
    }
    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
    private void LoadDetail()
    {
        cvm.getGlobal().observe(getViewLifecycleOwner(), this::viewData);
    }
    private void viewData(List<GlobalModel> list) {
        Log.d("Goblok", "awk");
        adapter = new GlobalAdapter(getContext(),list);

        if(list.size()>0)
        showLoading(false);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
    @NonNull
    private CoronaViewModel obtainViewModel(Application application) {
        ViewModelFactory factory = ViewModelFactory.getInstance(application);
        return factory.create(CoronaViewModel.class);
    }
}
