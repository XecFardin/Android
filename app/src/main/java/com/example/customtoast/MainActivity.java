package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btntoast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btntoast=(Button)findViewById(R.id.btntoast);
        btntoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Data is saved!",Toast.LENGTH_SHORT).show();

                ShowToast("Data is saved!");

            }
        });
    }
    public void ShowToast(String message)
    {
        View toastView= getLayoutInflater().inflate(R.layout.toast,(ViewGroup)findViewById(R.id.linlay));

        TextView tvtoast=(TextView) toastView.findViewById(R.id.tvtoast);
        tvtoast.setText(message);
        Toast toast=new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL,0,0);
        toast.show();
    }
}