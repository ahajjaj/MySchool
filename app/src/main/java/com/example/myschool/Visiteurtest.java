package com.example.myschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Visiteurtest extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visiteurtest);


        final Button button1 = findViewById(R.id.subscribe);
        final Button button2 = findViewById(R.id.btnmathematiques);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity1 = new Intent(Visiteurtest.this, RoleActivity.class);
                startActivity(gameActivity1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity5 = new Intent(Visiteurtest.this, Visiteurtest2.class);
                startActivity(gameActivity5);
    }
});



    }}
