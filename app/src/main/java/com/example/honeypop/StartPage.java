package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class StartPage extends AppCompatActivity {

    AppCompatButton start_btn, global, india, uk, usa, australia, bangladesh, indonesia;
    ImageView home, friend, account, history, gender;
    TextView gender_name, location_name;
    AppCompatImageView male, female, both;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        gender = findViewById(R.id.imageView4);

        location_name =findViewById(R.id.location_name);
        location_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryBottomSheet();
            }
            private void countryBottomSheet(){

                BottomSheetDialog bottomSheetDialog =new BottomSheetDialog(StartPage.this);
                bottomSheetDialog.setContentView(R.layout.country_bottom_sheet);
                bottomSheetDialog.setCancelable(true);
                bottomSheetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                bottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                bottomSheetDialog.getWindow().getAttributes().windowAnimations = com.google.android.material.R.style.Animation_Design_BottomSheetDialog;
                bottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
                bottomSheetDialog.show();

                global = bottomSheetDialog.findViewById(R.id.global);
                global.setOnClickListener(view1 -> {
                    global.setBackgroundResource(R.drawable.selected_option);
                    location_name.setText("Global");
                    bottomSheetDialog.dismiss();
                });

                india = bottomSheetDialog.findViewById(R.id.india);
                india.setOnClickListener(view1 -> {
                    india.setBackgroundResource(R.drawable.selected_option);
                    location_name.setText("India");
                    bottomSheetDialog.dismiss();
                });
                uk = bottomSheetDialog.findViewById(R.id.uk);
                uk.setOnClickListener(view1 -> {
                    uk.setBackgroundResource(R.drawable.selected_option);
                    location_name.setText("U.K.");
                    bottomSheetDialog.dismiss();
                });
                usa = bottomSheetDialog.findViewById(R.id.usa);
                usa.setOnClickListener(view1 -> {
                    usa.setBackgroundResource(R.drawable.selected_option);
                    location_name.setText("U.S.A.");
                    bottomSheetDialog.dismiss();
                });
                australia = bottomSheetDialog.findViewById(R.id.australia);
                australia.setOnClickListener(view1 -> {
                    australia.setBackgroundResource(R.drawable.selected_option);
                    location_name.setText("Australia");
                    bottomSheetDialog.dismiss();
                });
                bangladesh = bottomSheetDialog.findViewById(R.id.bangladesh);
                bangladesh.setOnClickListener(view1 -> {
                    bangladesh.setBackgroundResource(R.drawable.selected_option);
                    location_name.setText("Bangladesh");
                    bottomSheetDialog.dismiss();
                });
                indonesia = bottomSheetDialog.findViewById(R.id.indonesia);
                indonesia.setOnClickListener(view1 -> {
                    indonesia.setBackgroundResource(R.drawable.selected_option);
                    location_name.setText("Indonesia");
                    bottomSheetDialog.dismiss();
                });
            }
        });

        gender_name =findViewById(R.id.gender_name);
        gender_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genderBottomSheet();
            }
            private void genderBottomSheet() {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(StartPage.this);
                bottomSheetDialog.setContentView(R.layout.gender_bottom_sheet);
                bottomSheetDialog.setCancelable(true);
                bottomSheetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                bottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                bottomSheetDialog.getWindow().getAttributes().windowAnimations = com.google.android.material.R.style.Animation_Design_BottomSheetDialog;
                bottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
                bottomSheetDialog.show();
                male = bottomSheetDialog.findViewById(R.id.male);
                male.setOnClickListener(view -> {
                    male.setBackgroundResource(R.drawable.selected);
                    gender_name.setText("Male");
                    gender.setImageResource(R.drawable.male_symbol);
                    bottomSheetDialog.dismiss();
                });
                female = bottomSheetDialog.findViewById(R.id.female);
                female.setOnClickListener(view -> {
                    female.setBackgroundResource(R.drawable.selected);
                    gender.setImageResource(R.drawable.female_symbol);
                    gender_name.setText("Female");
                    bottomSheetDialog.dismiss();
                });
                both = bottomSheetDialog.findViewById(R.id.both);
                both.setOnClickListener(view -> {
                    both.setBackgroundResource(R.drawable.selected);
                    gender.setImageResource(R.drawable.gender_sign);
                    gender_name.setText("Male");
                    bottomSheetDialog.dismiss();
                });
            }
        });

        start_btn =findViewById(R.id.clickTOStart);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartPage.this, Host.class);
                startActivity(intent);
                finish();
            }

        });


        home = findViewById(R.id.home);
        friend =findViewById(R.id.friend);
        friend.setOnClickListener(view -> {
            Intent intent = new Intent(StartPage.this, Friends.class);
            startActivity(intent);
            finish();
        });

        account = findViewById(R.id.account);
        account.setOnClickListener(view -> {
            Intent intent = new Intent(StartPage.this, Account.class);
            startActivity(intent);
            finish();
        });

        history = findViewById(R.id.history);
        history.setOnClickListener(view -> {
            Intent intent =new Intent(StartPage.this, History.class);
            startActivity(intent);
            finish();
        });

    }
}