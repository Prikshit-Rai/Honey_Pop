package com.example.honeypop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_List extends Fragment {
    View v;
    RecyclerView recyclerView;
    Id_Adapter idAdapter;
    List<Model_Img> ID_List = new ArrayList<>();

    public Fragment_List(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragement_list, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        idAdapter = new Id_Adapter(ID_List, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(idAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ID_List  = add_ids();
    }

    private List<Model_Img> add_ids() {
        List<Model_Img> data = new ArrayList<>();
        data.add(new Model_Img(R.drawable.pic_1));
        data.add(new Model_Img(R.drawable.pic_2));
        data.add(new Model_Img(R.drawable.pic_3));
        data.add(new Model_Img(R.drawable.pic_4));
        data.add(new Model_Img(R.drawable.pic_5));
        data.add(new Model_Img(R.drawable.pic_6));
        data.add(new Model_Img(R.drawable.pic_7));
        data.add(new Model_Img(R.drawable.pic_8));
        data.add(new Model_Img(R.drawable.pic_9));
        data.add(new Model_Img(R.drawable.pic_10));
        return data;
    }
}
