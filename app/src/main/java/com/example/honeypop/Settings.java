package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    SwitchCompat blur_switch, msg_switch, like_switch, online_switch, call_switch;
    AppCompatButton block_account, log_out;
    ImageView home, history, friends;
    TextView help_feed, term_service, privacy_policy;
    ImageButton back_btn, notify_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this, Account.class);
            startActivity(intent);
            finish();
        });

        blur_switch =findViewById(R.id.blur_switch);
        blur_switch.setOnClickListener(view -> {
            if(blur_switch.isChecked()){
                Toast.makeText(Settings.this, "Blur Effect ON", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Settings.this, "Blur Effect OFF", Toast.LENGTH_SHORT).show();
            }
        });

        msg_switch =findViewById(R.id.msg_switch);
        msg_switch.setOnClickListener(view -> {
            if(msg_switch.isChecked()){
                Toast.makeText(Settings.this, "Message notification ON", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Settings.this, "Message notification OFF", Toast.LENGTH_SHORT).show();
            }
        });

        like_switch =findViewById(R.id.like_switch);
        like_switch.setOnClickListener(view -> {
            if(like_switch.isChecked()){
                Toast.makeText(Settings.this, "Like notification ON", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Settings.this, "Like notification OFF", Toast.LENGTH_SHORT).show();
            }
        });

        online_switch =findViewById(R.id.online_switch);
        online_switch.setOnClickListener(view -> {
            if(online_switch.isChecked()){
                Toast.makeText(Settings.this, "Friend online notification ON", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Settings.this, "Friend online notification OFF", Toast.LENGTH_SHORT).show();
            }
        });

        call_switch =findViewById(R.id.call_switch);
        call_switch.setOnClickListener(view -> {
            if(call_switch.isChecked()){
                Toast.makeText(Settings.this, "Call notification ON", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Settings.this, "Call notification OFF", Toast.LENGTH_SHORT).show();
            }
        });

        block_account =findViewById(R.id.block_acc);
        block_account.setOnClickListener(view -> {
            Toast.makeText(Settings.this, "Option isn't available yet!", Toast.LENGTH_SHORT).show();
        });

        log_out =findViewById(R.id.log_out);
        log_out.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


        home =findViewById(R.id.home);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this, StartPage.class);
            startActivity(intent);
            finish();
        });

        history =findViewById(R.id.history);
        history.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this, History.class);
            startActivity(intent);
            finish();
        });

        friends =findViewById(R.id.friend);
        friends.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this, Friends.class);
            startActivity(intent);
            finish();
        });

    }
    public void onBackPressed(){
        Intent intent = new Intent(Settings.this, Account.class);
        startActivity(intent);
        finish();
    }
}