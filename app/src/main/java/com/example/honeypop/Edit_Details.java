package com.example.honeypop;

import static com.example.honeypop.R.color.black;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Edit_Details extends AppCompatActivity {
    ImageView back_btn, preview, profile, home, history, accounts;
    TextView avatar1, avatar2, avatar3, avatar4, avatar5, avatar6;
    EditText nick_name, birthday, interests, language;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);
        back_btn =findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Edit_Details.this, Account.class);
            startActivity(intent);
            finish();
        });

        interests =findViewById(R.id.interests);
        language =findViewById(R.id.languages);
        nick_name =findViewById(R.id.nick_name_edit);
        nick_name.setOnClickListener(view -> {
            String name =nick_name.getText().toString().trim();
            if(name.length() <5){
                nick_name.setError("small Length");
            }
        });

        birthday =findViewById(R.id.birthday);
        birthday.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog =new DatePickerDialog(Edit_Details.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int yyyy, int mm, int dd) {
                    birthday.setText(dd+" : "+(mm+1)+" : "+yyyy);
                    birthday.setTextColor(birthday.getContext().getColor(black));
                }
            }, year, month, day);
            datePickerDialog.show();
        });

        preview=findViewById(R.id.preview);
        preview.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });

        profile=findViewById(R.id.profile);
        profile.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });

        avatar1=findViewById(R.id.avatar1);
        avatar1.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });

        avatar2=findViewById(R.id.avatar2);
        avatar2.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });
        avatar3=findViewById(R.id.avatar3);
        avatar3.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });
        avatar4=findViewById(R.id.avatar4);
        avatar4.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });
        avatar5=findViewById(R.id.avatar5);
        avatar5.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });
        avatar6=findViewById(R.id.avatar6);
        avatar6.setOnClickListener(view -> {
            Toast.makeText(Edit_Details.this, "Option not available yet!", Toast.LENGTH_SHORT).show();
        });


        home =findViewById(R.id.home);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(Edit_Details.this, StartPage.class);
            startActivity(intent);
            finish();
        });

        history =findViewById(R.id.history);
        history.setOnClickListener(view -> {
            Intent intent = new Intent(Edit_Details.this, History.class);
            startActivity(intent);
            finish();
        });

        accounts =findViewById(R.id.account);
        accounts.setOnClickListener(view -> {
            Intent intent = new Intent(Edit_Details.this, Account.class);
            startActivity(intent);
            finish();
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(Edit_Details.this, Account.class);
        startActivity(intent);
        finish();
    }
}