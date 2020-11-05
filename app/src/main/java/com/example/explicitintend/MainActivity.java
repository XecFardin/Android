package com.example.explicitintend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct1,btnAct2;
    TextView tvResult;
    final int Activity = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct1 = findViewById(R.id.btnAct1);
        btnAct2 = findViewById(R.id.btnAct2);
        tvResult = findViewById(R.id.tvResult);

        btnAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = etName.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,com.example.explicitintend.Activity1.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }

            }
        });
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,com.example.explicitintend.Activity2.class);
                startActivityForResult(intent,Activity);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Activity)
        {
            if (resultCode == RESULT_OK)
            {
                assert data != null;
                tvResult.setText(data.getStringExtra("surname"));
            }
            if (resultCode == RESULT_CANCELED)
            {
                tvResult.setText(R.string.string);
            }
        }
    }
}