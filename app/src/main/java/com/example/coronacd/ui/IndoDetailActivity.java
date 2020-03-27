package com.example.coronacd.ui;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronacd.R;
import com.example.coronacd.adapter.CoronaDetailAdapter;
import com.example.coronacd.model.CoronaDetailModel;
import com.example.coronacd.viewmodel.CoronaViewModel;
import com.example.coronacd.viewmodel.ViewModelFactory;

import java.util.List;

public class IndoDetailActivity extends AppCompatActivity {
    RecyclerView rv;
    CoronaDetailAdapter adapter;
    ProgressBar progressBar;
    CoronaViewModel cvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indo_detail);
        rv = findViewById(R.id.rv_detail_indo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar = findViewById(R.id.progressBar_IndoDetail);
        showLoading(true);
        cvm = obtainViewModel(getApplication());
        LoadDetail();

    }


    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void LoadDetail() {
        cvm.getDetali().observe(this, this::viewData);
    }

    private void viewData(List<CoronaDetailModel> list) {
        Log.d("Goblok", "awk");
        adapter = new CoronaDetailAdapter(getApplicationContext(), list);
        Log.e("Ini Detail", list.get(0).getAttributeDetail().getProvinsi());
        if (list.size() > 0)
            showLoading(false);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapter);
    }

    @NonNull
    private CoronaViewModel obtainViewModel(Application application) {
        ViewModelFactory factory = ViewModelFactory.getInstance(application);
        return factory.create(CoronaViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
