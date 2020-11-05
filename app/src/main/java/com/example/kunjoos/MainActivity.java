package com.example.kunjoos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements list_frag.ItemSelected {
    TextView tvdiscrip;
    String [] description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvdiscrip = findViewById(R.id.tvdiscrip);

        description = getResources().getStringArray(R.array.descriptions);
        if (findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailfrag))
                    .show(manager.findFragmentById(R.id.listfarg))
                    .commit();
        }
        if(findViewById(R.id.layout_land) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listfarg))
                    .show(manager.findFragmentById(R.id.detailfrag))
                    .commit();
        }

    }

    @Override
    public void onItemSelected(int index) {
        tvdiscrip.setText(description[index]);
        if (findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listfarg))
                    .show(manager.findFragmentById(R.id.detailfrag))
                    .addToBackStack(null)
                    .commit();
        }

    }
}