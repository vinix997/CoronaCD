package com.example.coronacd;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.internal.ParcelableSparseArray;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailDialogFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    TextView tv_name;
    TextView tv_pos;
    TextView tv_death;
    TextView tv_cured;
    TextView tv_active;
    int pos;
    int cured;
    int death;
    String name;
    int active;
    public DetailDialogFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetailDialogFragment newInstance(String name, int active, int cured, int death, int pos) {


        DetailDialogFragment f = new DetailDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();

        args.putString("name", name);
        args.putInt("pos", pos);
        args.putInt("cured", cured);
        args.putInt("death", death);
        args.putInt("active", active);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_dialog, container, false);
        tv_name = v.findViewById(R.id.country_name);
        tv_pos = v.findViewById(R.id.positive);
        tv_cured = v.findViewById(R.id.cured);
        tv_active = v.findViewById(R.id.active);
        tv_death = v.findViewById(R.id.death);
        pos = getArguments().getInt("pos");
        cured = getArguments().getInt("cured");
        name = getArguments().getString("name");
        death = getArguments().getInt("death");
        active = getArguments().getInt("active");
        tv_name.setText(name);
        tv_pos.setText("Positive: " +Integer.toString(pos));
        tv_cured.setText("Sembuh: " +Integer.toString(cured));
        tv_death.setText("Meninggal: " +Integer.toString(death));
        tv_active.setText("Aktif: " + Integer.toString(active));
        return v;
    }

}
