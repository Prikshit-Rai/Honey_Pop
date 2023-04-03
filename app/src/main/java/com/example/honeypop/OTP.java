package com.example.honeypop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OTP extends AppCompatActivity {
    EditText otp1, otp2, otp3, otp4;
    TextView resend, mobile_num;
    AppCompatButton next_btn;
    ImageView back_arrow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otp1=findViewById(R.id.otp1);
        otp2=findViewById(R.id.otp2);
        otp3=findViewById(R.id.otp3);
        otp4=findViewById(R.id.otp4);
        mobile_num =findViewById(R.id.mobile_number);
        Intent intent =getIntent();
        String num = intent.getStringExtra("number");
        mobile_num.setText(num);

        resend=findViewById(R.id.resend);
        resend.setOnClickListener(view -> {
            Toast.makeText(OTP.this, "OTP is 5693", Toast.LENGTH_SHORT).show();
        });

        next_btn =findViewById(R.id.next_btn);
        next_btn.setOnClickListener(view -> {
            String Otp1 = otp1.getText().toString() ;
            String Otp2 = otp2.getText().toString() ;
            String Otp3 =otp3.getText().toString() ;
            String Otp4 = otp4.getText().toString();
            if(Otp1.isEmpty() || Otp2.isEmpty() || Otp3.isEmpty() || Otp4.isEmpty()){
                Toast.makeText(OTP.this, "OTP can't be empty", Toast.LENGTH_SHORT).show();
            }
            if(Otp1.equals("5") && Otp2.equals("6") && Otp3.equals("9") && Otp4.equals("3")){
                Intent intent_next = new Intent(OTP.this, StartPage.class);
                startActivity(intent_next);
                finish();
            }
            else{
                Toast.makeText(OTP.this, "Wrong OTP", Toast.LENGTH_SHORT).show();
            }

        });

        back_arrow =findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent_back =new Intent(OTP.this, Mobile_SignIN.class);
            startActivity(intent_back);
            finish();
        });
    }

    public void onBackPressed(){
        Intent intent =new Intent(OTP.this, Mobile_SignIN.class);
        startActivity(intent);
        finish();
    }
}