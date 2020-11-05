package com.example.explicitintend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    EditText etSurname;
    Button btnSub;
    Button btncancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etSurname = findViewById(R.id.etSurname);
        btnSub = findViewById(R.id.btnSub);
        btncancle = findViewById(R.id.btncancle);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etSurname.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity2.this,"please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String surname = etSurname.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("surname",surname);
                    setResult(RESULT_OK,intent);
                    Activity2.this.finish();
                }


            }
        });
        btncancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                Activity2.this.finish();
            }
        });
    }
}