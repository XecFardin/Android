package com.example.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    ImageView Ivpic,ima1,ima2,ima3;
    Button btnnew;
    String name = " ",number=" ",web = " ",map=" ",Mood = " ";
    final int creat=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Ivpic = findViewById(R.id.Ivpic);
        ima1 = findViewById(R.id.ima1);
        ima2 = findViewById(R.id.ima2);
        ima3 = findViewById(R.id.ima3);
        btnnew = findViewById(R.id.btnnew);
        Ivpic.setVisibility(View.GONE);
        ima1.setVisibility(View.GONE);
        ima2.setVisibility(View.GONE);
        ima3.setVisibility(View.GONE);
        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,com.example.contact.MainActivity2.class);
                startActivityForResult(intent,creat);
            }
        });
        ima1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = getIntent().getStringExtra("number");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        ima2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String website = getIntent().getStringExtra("website");
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+ website));
                startActivity(intent);
            }
        });
        ima3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = getIntent().getStringExtra("location");
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == creat) {
                if (resultCode == RESULT_OK) {
                    Ivpic.setVisibility(View.VISIBLE);
                    ima1.setVisibility(View.VISIBLE);
                    ima2.setVisibility(View.VISIBLE);
                    ima3.setVisibility(View.VISIBLE);

                    name = data.getStringExtra("name");
                    number = data.getStringExtra("number");
                    web = data.getStringExtra("website");
                    map = data.getStringExtra("location");
                    Mood = data.getStringExtra("Mood");
                    if (Mood.equals("happy")) {
                        Ivpic.setImageResource(R.drawable.ic_sharp_mood_24);
                    } else if (Mood.equals("ok")) {
                        Ivpic.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24);
                    } else {
                        Ivpic.setImageResource(R.drawable.ic_baseline_mood_bad_24);
                    }
                }
                else
                {
                    Toast.makeText(this, "no data passed",Toast.LENGTH_SHORT).show();
                }

    }
}
}
