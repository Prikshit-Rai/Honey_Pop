package com.example.honeypop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Friend_Adapter extends RecyclerView.Adapter<Friend_Adapter.ViewHolder> {

    List<Model_text_IMG> data_list;
    Context context;
    public void setFilteredList(List<Model_text_IMG> filteredList){
        this.data_list =filteredList;
        notifyDataSetChanged();
    }

    public Friend_Adapter(List<Model_text_IMG> data_list, Context context){
        this.data_list =data_list;
        this.context= context;
    }

    @NonNull
    @Override
    public Friend_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friends_recycler, parent, false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Friend_Adapter.ViewHolder holder, int position) {
        Model_text_IMG friends_List = data_list.get(position);
        holder.friends_name.setText(friends_List.get_text());
        holder.profile.setImageResource(friends_List.get_img_id());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Don't click this",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView friends_name;
        ImageView profile;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            friends_name =itemView.findViewById(R.id.friend_name);
            profile = itemView.findViewById(R.id.profile);
            relativeLayout = itemView.findViewById(R.id.relative);
        }
    }
}
