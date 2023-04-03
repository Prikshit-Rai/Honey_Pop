package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

public class History extends AppCompatActivity {
    ImageView home, friend, account, history;
    AppCompatButton start_btn, link_btn;
    AppCompatImageView cancel_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        home =findViewById(R.id.home);
        home.setOnClickListener(view -> {
            Intent intent =new Intent(History.this, StartPage.class);
            startActivity(intent);
            finish();
        });

        friend =findViewById(R.id.friend);
        friend.setOnClickListener(view -> {
            Intent intent = new Intent(History.this, Friends.class);
            startActivity(intent);
            finish();
        });

        account =findViewById(R.id.account);
        account.setOnClickListener(view -> {
            Intent intent = new Intent(History.this, Account.class);
            startActivity(intent);
            finish();
        });

        history =findViewById(R.id.history);

        start_btn =findViewById(R.id.start_btn);
        start_btn.setOnClickListener(view -> {
            Dialog dialog =new Dialog(History.this);
            dialog.setContentView(R.layout.attention_dialog);
            dialog.setCancelable(false);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            dialog.show();
            link_btn =dialog.findViewById(R.id.link_btn);
            cancel_button = dialog.findViewById(R.id.cancel_button);
            cancel_button.setOnClickListener(view1 -> {
                dialog.dismiss();
            });

            link_btn.setOnClickListener(view1 -> {
                Intent intent = new Intent(History.this, AccountSecurity.class);
                startActivity(intent);
                finish();
            });


        });
    }
    public void onBackPressed(){
        Intent intent =new Intent(History.this, StartPage.class);
        startActivity(intent);
        finish();
    }
}