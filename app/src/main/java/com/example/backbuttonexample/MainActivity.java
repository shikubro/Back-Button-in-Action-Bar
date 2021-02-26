package com.example.backbuttonexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private AlertDialog.Builder alert ;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button_id){
            Intent intent = new Intent(MainActivity.this,back_button_practice_page.class);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        alert = new AlertDialog.Builder(MainActivity.this);
        alert.setIcon(R.drawable.welcome);
        alert.setTitle("Warning");
        alert.setMessage("Are you sure?");
        alert.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.create().show();
    }


}