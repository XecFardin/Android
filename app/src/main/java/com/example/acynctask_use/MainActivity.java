package com.example.acynctask_use;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton ibdice;
    EditText etnum;
    TextView tvresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibdice=(ImageButton)findViewById(R.id.ibdice);
        etnum=(EditText)findViewById(R.id.etnum);
        tvresult=(TextView)findViewById(R.id.tvresult);

        ibdice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int number = Integer.parseInt(etnum.getText().toString().trim());
                new ProcessDiceInBackground().execute(number);
            }

        });
    }
    public class ProcessDiceInBackground extends AsyncTask<Integer,Integer,String>
    {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(Integer.parseInt(etnum.getText().toString().trim()));
            dialog.show();
        }

        @Override
        protected String doInBackground(Integer... params) {


            int ones=0,twos=0,threes=0,fours=0,fives=0,sixes=0,randomnumber=0;


            Random random=new Random();
            String result;
            double currentProgress=0;
            double perivousProgress=0;
            for (int i=0;i < params[0];i++)
            {
                currentProgress=(double) i / params[0];
                if (currentProgress - perivousProgress >= 0.02)
                {
                    publishProgress(i);
                    perivousProgress = currentProgress;
                }
                randomnumber = random.nextInt(6)+1;
                switch (randomnumber)
                {
                    case 1:
                    {
                        ones++;
                        break;
                    }
                    case 2:
                    {
                        twos++;
                        break;
                    }
                    case 3:
                    {
                        threes++;
                        break;
                    }
                    case 4:
                    {
                        fours++;
                        break;
                    }
                    case 5:
                    {
                        fives++;
                        break;
                    }
                    default:sixes++;
                }
            }
            result="Result:-"+"\n"+"No. of ones:-"+ones+"\n"+"No. of Twos:-"+twos+"\n"+"No. of Threes:-"+threes+"\n"+"No. of four:-"+fours+"\n"+"No. of fives:-"+fives+"\n"+"No. of six:-"+sixes;

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.setProgress(values[0]);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
            tvresult.setText(s);
            Toast.makeText(MainActivity.this,"Process Done!",Toast.LENGTH_SHORT).show();
        }
    }
}