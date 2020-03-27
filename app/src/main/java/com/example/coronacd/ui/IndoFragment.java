package com.example.coronacd.ui;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronacd.R;
import com.example.coronacd.adapter.CoronaAdapter;
import com.example.coronacd.model.CoronaModel;
import com.example.coronacd.viewmodel.CoronaViewModel;
import com.example.coronacd.viewmodel.ViewModelFactory;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class IndoFragment extends Fragment {

    RecyclerView rv;
    ProgressBar progressBar;
    CoronaAdapter adapter;
    CoronaViewModel cvm;
    Button btn_detail;

    public IndoFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_indo, container, false);
        rv = v.findViewById(R.id.rv_indonesia);
        cvm = obtainViewModel(getActivity().getApplication());
        progressBar = v.findViewById(R.id.progressBar_Indo);
        showLoading(true);
        btn_detail = v.findViewById(R.id.btn_detail);
        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), IndoDetailActivity.class);
                startActivity(intent);
            }
        });
        LoadCorona();

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void LoadCorona() {
        cvm.getCorona(getContext()).observe(getViewLifecycleOwner(), this::viewData);

    }

    private void viewData(List<CoronaModel> list) {
        Log.d("Goblok", "awk");
        adapter = new CoronaAdapter(getContext(), list);
        Log.e("Error", list.get(0).getPositif());
        if (list.size() > 0)
            showLoading(false);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
    }

    @NonNull
    private CoronaViewModel obtainViewModel(Application application) {
        ViewModelFactory factory = ViewModelFactory.getInstance(application);
        return factory.create(CoronaViewModel.class);
    }
}
