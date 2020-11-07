package com.example.save_data_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText etname,etphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=(EditText)findViewById(R.id.etname);
        etphone=(EditText)findViewById(R.id.etphone);

    }

    public void btnSubmit(View view) {
        String name = etname.getText().toString().trim();
        String cell=etphone.getText().toString().trim();

        try
        {
            ContactDB db = new ContactDB(this);
            db.open();
            db.createentry(name,cell);
            db.close();
            Toast.makeText(MainActivity.this,"Successfully saved!",Toast.LENGTH_SHORT).show();
            etname.setText("");
            etphone.setText("");
        }
        catch (SQLiteException e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public void btnShowData(View view) {

        startActivity(new Intent(this,Data.class));
    }

    public void btnEditData(View view) {
        try
        {
            ContactDB db = new ContactDB(this);
            db.open();
            db.updateentry("1","John Jurrise","2347483940");
            db.close();
            Toast.makeText(MainActivity.this,"Successfully updated!",Toast.LENGTH_SHORT).show();

        }
        catch (SQLiteException e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public void btnDeleteData(View view)
    {
        try
        {
            ContactDB db = new ContactDB(this);
            db.open();
            db.deleteentry("1");
            db.close();
            Toast.makeText(MainActivity.this,"Successfully deleted!",Toast.LENGTH_SHORT).show();

        }
        catch (SQLiteException e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}