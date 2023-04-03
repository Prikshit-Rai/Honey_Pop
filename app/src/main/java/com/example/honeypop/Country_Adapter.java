package com.example.honeypop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Country_Adapter extends RecyclerView.Adapter<Country_Adapter.ViewHolder> {
    List<Model_Text> data_list;
    Context context;
    Select select;

    public interface Select {
        void select (Model_Text data);
    }

    public Country_Adapter(List<Model_Text> data_list, Context context,Select select){
        this.data_list =data_list;
        this.context= context;
        this.select =select;
    }

    @NonNull
    @Override
    public Country_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_name , parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Country_Adapter.ViewHolder holder, int position) {
        Model_Text modelText =data_list.get(position);
        holder.name.setText(modelText.get_Text());
        holder.itemView.setOnClickListener(view -> {
            select.select(data_list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return data_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
