package com.example.coronacd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

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
    private void LoadDetail()
    {
        cvm.getDetali().observe(this, this::viewData);
    }
    private void viewData(List<CoronaDetailModel> list) {
        Log.d("Goblok", "awk");
        adapter = new CoronaDetailAdapter(getApplicationContext(),list);
        Log.e("Ini Detail",list.get(0).getAttributeDetail().getProvinsi());
        if(list.size()>0)
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
