package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btncall,btncallFriend,btnweb,btnmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncall = findViewById(R.id.btncall);
        btncallFriend =findViewById(R.id.btncallFriend);
        btnweb = findViewById(R.id.btnweb);
        btnmap = findViewById(R.id.btnmap);

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);

            }
        });
        btncallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9421150851"));
                startActivity(intent);

            }
        });
        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.pornky.com"));
                startActivity(intent);

            }
        });
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q= Penjim,Goa"));
                startActivity(intent);

            }
        });
    }
}