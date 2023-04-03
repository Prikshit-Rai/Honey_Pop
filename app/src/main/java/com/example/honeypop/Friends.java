package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Friends extends AppCompatActivity {
    ImageView home, history, accounts, notify_bell;
    SearchView search_bar;
    RecyclerView recyclerView;
    Friend_Adapter adapter;
    List<Model_text_IMG> friends_list = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        search_bar = findViewById(R.id.search_bar);
        search_bar.clearFocus();
        search_bar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }

        });

        friends_list = add_friends();

        recyclerView =findViewById(R.id.recyclerView);
        adapter =new Friend_Adapter( friends_list, getApplication());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Friends.this));

        notify_bell =findViewById(R.id.notify_icon);
        notify_bell.setOnClickListener(view -> {
            Toast.makeText(Friends.this, "No Notification", Toast.LENGTH_SHORT).show();
        });

        home =findViewById(R.id.home);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(Friends.this, StartPage.class);
            startActivity(intent);
            finish();
        });

        history =findViewById(R.id.history);
        history.setOnClickListener(view -> {
            Intent intent = new Intent(Friends.this, History.class);
            startActivity(intent);
            finish();
        });

        accounts =findViewById(R.id.account);
        accounts.setOnClickListener(view -> {
            Intent intent = new Intent(Friends.this, Account.class);
            startActivity(intent);
            finish();
        });
    }

    private List<Model_text_IMG> add_friends() {
        List<Model_text_IMG> data =new ArrayList<>();
        data.add(new Model_text_IMG("Honey Pop Team", R.drawable.honey_pop_team));
        data.add(new Model_text_IMG("Customer Service", R.drawable.customer));
        data.add(new Model_text_IMG("Hawkeye", R.drawable.profile));
        data.add(new Model_text_IMG("Cartoon", R.drawable.profile));
        data.add(new Model_text_IMG("Captain America", R.drawable.profile));
        data.add(new Model_text_IMG("Thor", R.drawable.profile));
        data.add(new Model_text_IMG("Iron Man", R.drawable.profile));
        return data;
    }

    private void filterList(String newText) {
        List<Model_text_IMG> filteredList =new ArrayList<>();
        for(Model_text_IMG item : friends_list ){
            if(item.get_text().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(Friends.this, "No Data found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter.setFilteredList(filteredList);
        }
    }

    public void onBackPressed(){
        Intent intent =new Intent(Friends.this, StartPage.class);
        startActivity(intent);
        finish();
    }
}