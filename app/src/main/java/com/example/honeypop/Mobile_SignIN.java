package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mobile_SignIN extends AppCompatActivity {
    EditText mobile_number;
    AppCompatButton next_btn;
    AppCompatImageView cancel;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_sign_in);
        mobile_number =findViewById(R.id.mobile_number);

        cancel =findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile_number.setText("");
                mobile_number.setHint("");
            }
        });

        next_btn= findViewById(R.id.next_btn);
        next_btn.setOnClickListener(view -> {
            String num = mobile_number.getText().toString();
            Pattern ptrn = Pattern.compile("[0-9]{10}");
            Matcher matcher = ptrn.matcher(num);
            if(num.isEmpty()){
                mobile_number.setError("Can't be empty");
            }
            if(!matcher.matches()){
                mobile_number.setError("Invalid");
            }
            else{
                Intent intent =new Intent(Mobile_SignIN.this, OTP.class);
                intent.putExtra("number", num);
                startActivity(intent);
                finish();
            }

        });
    }

    public void onBackPressed(){
        Intent intent =new Intent(Mobile_SignIN.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}