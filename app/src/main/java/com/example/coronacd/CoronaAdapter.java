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

public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.ViewHolder> {
    private List<CoronaModel> listCorona;
    private Context context;

    public CoronaAdapter(Context context, List<CoronaModel> listCorona) {
        this.context = context;
        this.listCorona = listCorona;
    }

    @NonNull
    @Override
    public CoronaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_corona, parent, false);
        Log.e("adapter", " koko");
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaAdapter.ViewHolder holder, int position) {
        holder.name.setText("Indonesia: " + listCorona.get(holder.getAdapterPosition()).getName());
        holder.positif.setText("Positive: " + listCorona.get(holder.getAdapterPosition()).getPositif());
        holder.sembuh.setText("Sembuh: " + listCorona.get(holder.getAdapterPosition()).getSembuh());
        holder.meninggal.setText("Meninggal: " + listCorona.get(holder.getAdapterPosition()).getMeninggal());
    }

    @Override
    public int getItemCount() {
        return listCorona.size();
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
