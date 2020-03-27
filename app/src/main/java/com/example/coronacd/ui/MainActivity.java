package com.example.coronacd.ui;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.coronacd.R;


public class MainActivity extends FragmentActivity {
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fl, new IndoStatusFragment());
        ft.commit();


    }


}
