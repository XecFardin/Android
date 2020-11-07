package com.example.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnpermission;
    private static final  int UNIQUE_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnpermission=(Button)findViewById(R.id.btnpermission);
        btnpermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},UNIQUE_CODE);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Permission Granted! Thank you!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
     if (requestCode ==UNIQUE_CODE)
     {
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(MainActivity.this,"Thank you! Permission Granted! ",Toast.LENGTH_SHORT).show();
        }
        else if (grantResults[0]==PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage("This permission is important to save file to the phone! Please permit it!").setTitle("Important permission required");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, UNIQUE_CODE);
                    }
                });
                dialog.setNegativeButton("ON THANKS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Cannot be done! ", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
            else
            {
                Toast.makeText(MainActivity.this,"we will never show you this again",Toast.LENGTH_SHORT).show();
            }
        }

     }
    }
}