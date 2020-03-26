package com.example.coronacd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GlobalAdapter extends RecyclerView.Adapter<GlobalAdapter.ViewHolder> {
    List<GlobalModel> list;
    Context context;
    public GlobalAdapter(Context context, List<GlobalModel> list)
    {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public GlobalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_coronas,parent,false);
        return new GlobalAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GlobalAdapter.ViewHolder holder, int position) {
        holder.name.setText("Nama Negara: " + list.get(holder.getAdapterPosition()).getAttributes().getCountryRegion());
        holder.positif.setText("Positif: " + Integer.toString(list.get(holder.getAdapterPosition()).getAttributes().getConfirmed()));
        holder.active.setText("Aktif: " + Integer.toString(list.get(holder.getAdapterPosition()).getAttributes().getActive()));
        holder.meninggal.setText("Meninggal: " +Integer.toString(list.get(holder.getAdapterPosition()).getAttributes().getDeaths()));
        holder.sembuh.setText("Sembuh: " +Integer.toString(list.get(holder.getAdapterPosition()).getAttributes().getRecovered()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView positif;
        TextView active;
        TextView sembuh;
        TextView meninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            active = itemView.findViewById(R.id.active);
            positif = itemView.findViewById(R.id.positive);
            sembuh = itemView.findViewById(R.id.cured);
            meninggal = itemView.findViewById(R.id.death);
        }
    }
}
