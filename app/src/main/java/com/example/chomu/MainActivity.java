package com.example.chomu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView Ivpic,ball,bat,rug;
    Button btnchange;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ivpic = findViewById(R.id.Ivpic);
        ball = findViewById(R.id.ball);
        bat = findViewById(R.id.bat);
        rug = findViewById(R.id.rug);
        btnchange = findViewById(R.id.btnchange);
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ball.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x=0;
                    }
                });
                bat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x=1;
                    }
                });
                rug.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x = 2;
                    }
                });

                if (x==0)
                {
                    Ivpic.setImageResource(R.drawable.ic_baseline_sports_basketball_24);
                }
                if (x==1)
                {
                    Ivpic.setImageResource(R.drawable.ic_baseline_sports_cricket_24);
                }
                if (x==2)
                {
                    Ivpic.setImageResource(R.drawable.ic_baseline_sports_football_24);
                }

            }
        });




    }
}