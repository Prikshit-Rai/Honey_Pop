package com.example.honeypop;

import static com.example.honeypop.R.color.black;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {
    AppCompatImageButton back_btn;
    AppCompatImageView male, female;
    EditText name;
    TextView birthday;
    AppCompatButton  finish_btn;
    ImageView name_info, birthday_info, gender_info;
    private int year, month, day;
    boolean gender;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name_info =findViewById(R.id.name_info);
        birthday_info =findViewById(R.id.birthday_info);
        gender_info= findViewById(R.id.gender_info);

        back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent =new Intent(SignUp.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        gender = false;
        male.setOnClickListener(view -> {
            gender= true;
            male.setBackgroundResource(R.drawable.selected);
            female.setBackgroundResource(R.drawable.unselected);
        });

        female.setOnClickListener(view -> {
            gender= true;
            female.setBackgroundResource(R.drawable.selected);
            male.setBackgroundResource(R.drawable.unselected);
        });

        name =findViewById(R.id.name);
        birthday=findViewById(R.id.birthday_edit);
        birthday.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                birthday.setTextColor(R.color.greyLight);
                birthday.setText("Birthday");
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog =new DatePickerDialog(SignUp.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yyyy, int mm, int dd) {
                        birthday.setText(dd+" : "+(mm+1)+" : "+yyyy);
                        birthday.setTextColor(birthday.getContext().getColor(black));
                    }
                }, year, month, day);
                datePickerDialog.show();
                birthday.setTextColor(black);
            }
        });

        finish_btn= findViewById(R.id.finish_btn);
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = name.getText().toString();
                String user_birth = birthday.getText().toString();
                if(gender==false){
                    Toast.makeText(SignUp.this, "Gender not selected", Toast.LENGTH_SHORT).show();
                }
                if(user_name.isEmpty()){
                    name.setError("Required Field");
                }
                if(user_birth.isEmpty()){
                    birthday.setError("Required Field");
                }
                else if(user_name.length()<5){
                    name.setError("Nickname is too small");
                }
                else{
                    Intent intent = new Intent(SignUp.this, StartPage.class);
                    startActivity(intent);
                    finish();
                }

            }
        });



    }

    public void onBackPressed(){
        Intent intent =new Intent(SignUp.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}