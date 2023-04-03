package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class AccountSecurity extends AppCompatActivity {

    ImageButton back_btn;
    AppCompatButton link_email, link_phone;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);

        back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(AccountSecurity.this, Account.class);
            startActivity(intent);
            finish();
        });

        link_phone =findViewById(R.id.link_phone);
        link_phone.setOnClickListener(view -> {
            Toast.makeText(AccountSecurity.this, "Can't link Phone Number", Toast.LENGTH_SHORT).show();
        });

        link_email =findViewById(R.id.link_email);
        link_email.setOnClickListener(view -> {
            Toast.makeText(AccountSecurity.this, "Can't link Email Address", Toast.LENGTH_SHORT).show();
        });

    }
    public void onBackPressed(){
        Intent intent = new Intent(AccountSecurity.this, Account.class);
        startActivity(intent);
        finish();
    }
}