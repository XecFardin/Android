package com.example.save_data_textfile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etname, etsurname;
    TextView tvresult;
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText) findViewById(R.id.etname);
        etsurname = (EditText) findViewById(R.id.etsurname);
        tvresult = (TextView) findViewById(R.id.tvresult);

        persons= new ArrayList<Person>();
        loadData();


    }

    private void loadData() {
        persons.clear();
        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFrontFile;
        if(file.exists())
        {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));
                while ((lineFrontFile=reader.readLine())!=null)
                {
                    StringTokenizer tokenizer=new StringTokenizer(lineFrontFile,",");
                    Person person = new Person(tokenizer.nextToken(),tokenizer.nextToken());
                    persons.add(person);
                }
                reader.close();
                setTextToTextView();
            }
            catch (IOException e)
            {
                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void btnAddData(View v) {
        String name = etname.getText().toString().trim();
        String surname=etsurname.getText().toString().trim();

        Person person = new Person(name,surname);
        persons.add(person);

        setTextToTextView();
    }

    private void setTextToTextView() {
        StringBuilder text = new StringBuilder(" ");
        for (int i=0;i<persons.size();i++)
        {
            text.append(persons.get(i).getName()).append(" ").append(persons.get(i).getSurname()).append("\n");

        }
        tvresult.setText(text.toString());

    }

    public void btnSaveData(View v) {

        try
        {
            FileOutputStream file=openFileOutput("Data.txt",MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for (int i=0;i<persons.size();i++)
            {
                outputFile.write(persons.get(i).getName()+","+persons.get(i).getSurname()+"\n");
            }
            outputFile.flush();
            outputFile.close();
            Toast.makeText(MainActivity.this,"Successfully Saved!",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}


