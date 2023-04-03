package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Host extends AppCompatActivity {

    ImageView back_btn;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter countryFragAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Host.this, StartPage.class);
            startActivity(intent);
            finish();
        });

        viewPager = findViewById(R.id.recyclerView_ids);
        tabLayout = findViewById(R.id.country);

        countryFragAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        add_country();
        viewPager.setAdapter(countryFragAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void add_country() {
        countryFragAdapter.AddFragment(new Fragment_List(), "Hindi");
        countryFragAdapter.AddFragment(new Fragment_List(), "Russian");
        countryFragAdapter.AddFragment(new Fragment_List(), "Portuguese");
        countryFragAdapter.AddFragment(new Fragment_List(), "Spanish");
        countryFragAdapter.AddFragment(new Fragment_List(), "English");
        countryFragAdapter.AddFragment(new Fragment_List(), "Italian");
    }

    public void onBackPressed(){
        Intent intent = new Intent(Host.this, StartPage.class);
        startActivity(intent);
        finish();
    }
}