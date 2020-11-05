package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btncarinfo,btnowner;
    ImageView Ivmake;
    TextView tvmodle,tvname,tvtel;
    FragmentManager fragmentManager;
    Fragment ButtonFrag,listFrag,CarInfoFrag,OwnerFrag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncarinfo = findViewById(R.id.btncarinfo);
        btnowner=findViewById(R.id.btnowner);
        Ivmake = findViewById(R.id.IvMake);
        tvmodle=findViewById(R.id.tvmodel);
        tvname=findViewById(R.id.tvname);
        tvtel=findViewById(R.id.tvtel);
        fragmentManager=getSupportFragmentManager();
        listFrag=fragmentManager.findFragmentById(R.id.listFrag);
        ButtonFrag=fragmentManager.findFragmentById(R.id.BottonFrag);
        CarInfoFrag=fragmentManager.findFragmentById(R.id.CarInfoFrag);
        OwnerFrag=fragmentManager.findFragmentById(R.id.OwnerFrag);
        fragmentManager.beginTransaction()
                .show(ButtonFrag)
                .show(listFrag)
                .show(CarInfoFrag)
                .hide(OwnerFrag)
                .commit();


        btncarinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .show(CarInfoFrag)
                        .hide(OwnerFrag)
                        .commit();


            }
        });
        btnowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .hide(CarInfoFrag)
                        .show(OwnerFrag)
                        .commit();


            }
        });
        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        tvname.setText(ApplicationClass.cars.get(index).getOwnerName());
        tvtel.setText(ApplicationClass.cars.get(index).getOwnerTel());
        tvmodle.setText(ApplicationClass.cars.get(index).getModel());
        if (ApplicationClass.cars.get(index).getMake().equals("Volkswagen"))
        {
            Ivmake.setImageResource(R.drawable.volkswagen);
        }
        else if (ApplicationClass.cars.get(index).getMake().equals("Mercedes"))
        {
            Ivmake.setImageResource(R.drawable.mercedes);
        }
        else
        {
            Ivmake.setImageResource(R.drawable.nissan);
        }

    }
}