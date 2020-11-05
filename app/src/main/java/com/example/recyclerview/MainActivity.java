package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {


    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager LayoutManager;
    Button btnadd;

    ArrayList<person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        btnadd = findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people.add(new person("Sushant","Singh Rajput","Plane"));
                myAdapter.notifyDataSetChanged();
            }
        });

        people = new ArrayList<person>();
        people.add(new person("John", "Rambo", "Bus"));
        people.add(new person("Chuck", "Noris", "Bus"));
        people.add(new person("Peter", "Parker", "Plane"));
        people.add(new person("Tom", "Cruze", "Plane"));
        people.add(new person("John", "Rambo", "Bus"));
        people.add(new person("Chuck", "Noris", "Bus"));
        people.add(new person("Peter", "Parker", "Plane"));
        people.add(new person("Tom", "Cruze", "Plane"));
        people.add(new person("John", "Rambo", "Bus"));
        people.add(new person("Chuck", "Noris", "Bus"));
        people.add(new person("Peter", "Parker", "Plane"));
        people.add(new person("Tom", "Cruze", "Plane"));

        myAdapter = new PersonAdapter(this, people);
        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,"Surname:" + people.get(index).getSurname(),Toast.LENGTH_SHORT).show();

    }
}