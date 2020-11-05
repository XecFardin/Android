package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    EditText etname, etnumber, etwebsite, etlocation;
    ImageView btmag1, btmag2, btmag3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etname = findViewById(R.id.etname);
        etnumber = findViewById(R.id.etnumber);
        etwebsite = findViewById(R.id.etwebsite);
        etlocation = findViewById(R.id.etlocaion);
        btmag1 = findViewById(R.id.btmag1);
        btmag2 = findViewById(R.id.btmag2);
        btmag3 = findViewById(R.id.btmag3);


        btmag1.setOnClickListener(this);
        btmag2.setOnClickListener(this);
        btmag3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (etname.getText().toString().isEmpty() && etnumber.getText().toString().isEmpty() && etwebsite.getText().toString().isEmpty() && etlocation.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity2.this, "please fill all the fields", Toast.LENGTH_SHORT).show();

        } else {
            Intent intent = new Intent();
            intent.putExtra("name", etname.getText().toString().trim());
            intent.putExtra("number", etnumber.getText().toString().trim());
            intent.putExtra("website", etwebsite.getText().toString().trim());
            intent.putExtra("location", etlocation.getText().toString().trim());
            if (view.getId()== R.id.btmag1)
            {
                intent.putExtra("Mood","happy");
            }
            else if (view.getId()== R.id.btmag2)
            {
                intent.putExtra("Mood","ok");
            }
            else
            {
                intent.putExtra("Mood","sad");
            }
            setResult(RESULT_OK,intent);
            MainActivity2.this.finish();
        }
    }
}