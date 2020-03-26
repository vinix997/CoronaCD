package com.example.coronacd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoronaDetailAdapter extends RecyclerView.Adapter<CoronaDetailAdapter.ViewHolder> {
    private List<CoronaDetailModel> listAttribute;
    Context context;
    public CoronaDetailAdapter(Context context,List<CoronaDetailModel> listAttribute) {
        this.context = context;
        this.listAttribute = listAttribute;
    }

    @NonNull
    @Override
    public CoronaDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_corona, parent, false);

        Log.e("adapter", " koko");
        return new CoronaDetailAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaDetailAdapter.ViewHolder holder, int position) {
        holder.name.setText("Nama Provinsi: " + listAttribute.get(holder.getAdapterPosition()).getAttributeDetail().getProvinsi());
        holder.meninggal.setText("Meninggal: " + Integer.toString(listAttribute.get(holder.getAdapterPosition()).getAttributeDetail().getKasusMeni()));
        holder.sembuh.setText("Sembuh: " + Integer.toString(listAttribute.get(holder.getAdapterPosition()).getAttributeDetail().getKasusSem()));
        holder.positif.setText("Positif: " + Integer.toString(listAttribute.get(holder.getAdapterPosition()).getAttributeDetail().getKasusPos()));
    }

    @Override
    public int getItemCount() {
        return listAttribute.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView positif;
        TextView sembuh;
        TextView meninggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            positif = itemView.findViewById(R.id.positive);
            sembuh = itemView.findViewById(R.id.cured);
            meninggal = itemView.findViewById(R.id.death);
        }
    }

}
