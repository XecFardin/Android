package com.example.user_prefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvintro;
    EditText ptname;
    Button btnSubmit;

    public static final String MY_PREF_FILENAME="com.example.user_prefrence.Names";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvintro=(TextView)findViewById(R.id.tvintro);
        ptname=(EditText)findViewById(R.id.ptname);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);

        SharedPreferences pref = getSharedPreferences(MY_PREF_FILENAME,MODE_PRIVATE);
        String user=pref.getString("User","");
        tvintro.setText("Welcome to my app " + user + "!");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ptname.getText().toString().trim();
                tvintro.setText("Welcome to my app "+name+"!");
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREF_FILENAME,MODE_PRIVATE).edit();
                editor.putString("User",name);
                editor.commit();


            }
        });
    }
}