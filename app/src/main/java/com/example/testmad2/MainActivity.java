package com.example.testmad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relative1;
    Button btn1, btnExplicit, btnImplicit;
    RadioButton radioWeb, radioAndroid;
    RadioGroup radioGroup;
    ToggleButton toggle1;
    CheckBox check1, check2, check3;
    RatingBar rating1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relative1 = findViewById(R.id.relative1);
        btn1 = findViewById(R.id.btn1);
        btnExplicit = findViewById(R.id.btnExplicit);
        btnImplicit = findViewById(R.id.btnImplicit);
        radioGroup = findViewById(R.id.radioGroup);
        radioWeb = findViewById(R.id.radioWeb);
        radioAndroid = findViewById(R.id.radioAndroid);
        rating1 = findViewById(R.id.rating1);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        toggle1 = findViewById(R.id.toggle1);


        check1.setOnCheckedChangeListener((button, checkID) -> {
            if (check1.isChecked())
                Toast.makeText(this, "Java", Toast.LENGTH_SHORT).show();
        });
        check2.setOnCheckedChangeListener((button, checkID) -> {
            if (check2.isChecked())
                Toast.makeText(this, "JS", Toast.LENGTH_SHORT).show();
        });
        check3.setOnCheckedChangeListener((button, checkID) -> {
            if (check3.isChecked())
                Toast.makeText(this, "WIFI on", Toast.LENGTH_SHORT).show();
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch(checkedId){
                case (R.id.radioWeb):
                    Toast.makeText(MainActivity.this, "PHP", Toast.LENGTH_SHORT).show();
                    break;
                case (R.id.radioAndroid):
                    Toast.makeText(MainActivity.this, "C#", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        btn1.setOnClickListener(v -> {
            if (check1.isChecked())
                Toast.makeText(this, "Java",Toast.LENGTH_SHORT).show();
            if (check2.isChecked())
                Toast.makeText(this, "JS",Toast.LENGTH_SHORT).show();
            if (check3.isChecked())
                Toast.makeText(this, "Wifi On",Toast.LENGTH_SHORT).show();

            if (rating1.getRating() > 1){
                float rate = (float) rating1.getRating();
                String ra = String.valueOf(rate);
                Toast toast = Toast.makeText(this, ra, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 340, 200);
                toast.show();
            }
        });

        btnExplicit.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        });

        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        toggle1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                relative1.setBackgroundColor(Color.GREEN);
            } else {
                relative1.setBackgroundColor(Color.YELLOW);
            }
        });
    }
}