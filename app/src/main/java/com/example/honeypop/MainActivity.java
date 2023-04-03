package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatImageButton google_login,mobile_login, email_login, twitter_login;
    AppCompatButton trouble_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        google_login =findViewById(R.id.login_google);
        google_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.login_google_dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(true);
                AppCompatButton continue_guest =dialog.findViewById(R.id.continue_guest);
                continue_guest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, StartPage.class);
                        startActivity(intent);
                        finish();
                    }
                });

                AppCompatButton add_account = dialog.findViewById(R.id.add_account);
                add_account.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "This is possible at this moment.\nPlease continue as guest", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

        mobile_login = findViewById(R.id.login_mobile);
        mobile_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mobile_intent =new Intent(MainActivity.this, Mobile_SignIN.class);
                startActivity(mobile_intent);
                finish();
            }
        });

        email_login = findViewById(R.id.login_email);
        email_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email_intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(email_intent);
                finish();
            }
        });

        twitter_login= findViewById(R.id.login_twitter);
        twitter_login.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "This option is not available yet.", Toast.LENGTH_SHORT).show();
        });


        trouble_login = findViewById(R.id.login_trouble);
        trouble_login.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Solve Problem by yourself", Toast.LENGTH_SHORT).show();
        });

    }
}