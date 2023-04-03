package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;

public class Account extends AppCompatActivity {

    AppCompatButton buyCoin;
    ImageView edit_btn, home, history, friends;
    ImageButton back_btn;
    TableRow account_security, buy_coin, backpack, like, share, safety, privacy, setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent =new Intent(Account.this, StartPage.class);
            startActivity(intent);
            finish();

            onBackPressed();
        });

        home =findViewById(R.id.home);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this, StartPage.class);
            startActivity(intent);
            finish();
        });

        history =findViewById(R.id.history);
        history.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this, History.class);
            startActivity(intent);
            finish();
        });

        friends =findViewById(R.id.friend);
        friends.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this, Friends.class);
            startActivity(intent);
            finish();
        });

        setting = findViewById(R.id.setting_go_btn);
        setting.setOnClickListener(view -> {
            Intent intent =new Intent(Account.this, Settings.class);
            startActivity(intent);
            finish();
        });

        account_security =findViewById(R.id.acc_security_go_btn);
        account_security.setOnClickListener(view -> {
            Intent intent =new Intent(Account.this, AccountSecurity.class);
            startActivity(intent);
            finish();
        });

        buy_coin =findViewById(R.id.buy_coin_go_btn);
        buy_coin.setOnClickListener(view -> {
            Intent intent =new Intent(Account.this, BuyCoins.class);
            startActivity(intent);
            finish();
        });

        buyCoin =findViewById(R.id.buyCoin_btn);
        buyCoin.setOnClickListener(view -> {
            Intent intent =new Intent(Account.this, BuyCoins.class);
            startActivity(intent);
            finish();
        });

        edit_btn =findViewById(R.id.edit_btn);
        edit_btn.setOnClickListener(view -> {
            Intent intent =new Intent(Account.this, Edit_Details.class);
            startActivity(intent);
            finish();
        });

    }

    public void onBackPressed(){
        Intent intent =new Intent(Account.this, StartPage.class);
        startActivity(intent);
        finish();
    }
}