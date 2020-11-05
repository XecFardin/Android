package com.example.myappp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView firstname,lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname=(AutoCompleteTextView)findViewById(R.id.firstname);
        String[] names = {"James","Abdulla","Safwan","Siddhi","Madhukar","Mubasheer"};
        ArrayAdapter<String>adapter
                =new ArrayAdapter<String>(this,R.layout.custom_design_autocomplete,names);
        firstname.setThreshold(1);
        firstname.setAdapter(adapter);
        lastname =(AutoCompleteTextView)findViewById(R.id.lastname);
        String[] lnames = {"Shaikh","Tiwari","Salgaoukar","Sayeed","Norris"};
        ArrayAdapter<String>adapter1
                =new ArrayAdapter<String>(this,R.layout.custom_design_autocomplete,lnames);
        lastname.setThreshold(1);
        lastname.setAdapter(adapter1);


    }
}