package com.example.fragmentwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    EditText etname,etphone;
    TextView tvname,tvphone;
    Button btnadd;
    ListFrag listFrag;
    FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvname = findViewById(R.id.tvname);
        tvphone = findViewById(R.id.tvnumber);
        etname = findViewById(R.id.etname);
        etphone = findViewById(R.id.etphone);
        btnadd = findViewById(R.id.btnadd);

        fragmentManager =this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listfrag);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etname.getText().toString().isEmpty()||etphone.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"please enter all fields!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ApplicationClass.people.add(new Person(etname.getText().toString().trim(),etphone.getText().toString().trim()));
                    Toast.makeText(MainActivity.this,"Person Successfully added!",Toast.LENGTH_SHORT).show();
                    etname.setText(null);
                    etphone.setText(null);
                    listFrag.datachanged();
                }

            }
        });
        onItemClickied(0);

    }

    @Override
    public void onItemClickied(int index) {
        tvname.setText(ApplicationClass.people.get(index).getName());
        tvphone.setText(ApplicationClass.people.get(index).getPhone());

    }
}