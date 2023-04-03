package com.example.honeypop;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Id_Adapter extends RecyclerView.Adapter<Id_Adapter.ViewHolder> {
    List<Model_Img> data_list;
    Context context;
    public Id_Adapter(List<Model_Img> id_list, Context context) {
        this.data_list =id_list;
        this.context =context;
    }

    @NonNull
    @Override
    public Id_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.id_view , parent, false);
        Id_Adapter.ViewHolder holder = new Id_Adapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Id_Adapter.ViewHolder holder, int position) {
        Model_Img model_img = data_list.get(position);
        holder.profile_pic.setImageResource(model_img.get_img_id());

    }

    @Override
    public int getItemCount() {
        return data_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile_pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_pic =itemView.findViewById(R.id.profile_pic);
        }
    }
}
