package com.example.save_data_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Data extends AppCompatActivity {

    TextView tvdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tvdata=(TextView)findViewById(R.id.tvdata);
        try {
            ContactDB db = new ContactDB(this);
            db.open();
            tvdata.setText(db.getData());
            db.close();
        }
        catch (SQLiteException e)
        {
            Toast.makeText(Data.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}