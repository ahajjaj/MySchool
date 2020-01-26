package com.example.myschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Mathematiques extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathematiques);



        final Button button1 = findViewById(R.id.btnquiz);
        final Button button2 = findViewById(R.id.btncours);
        final Button button3 = findViewById(R.id.btnvideos);
        final Button button4 = findViewById(R.id.btnsynthese);
        final Button button5 = findViewById(R.id.btnexercices);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity1 = new Intent(Mathematiques.this, Quiz.class);
                startActivity(gameActivity1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity2 = new Intent(Mathematiques.this, Listecours.class);
                startActivity(gameActivity2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity2 = new Intent(Mathematiques.this, Exercices.class);
                startActivity(gameActivity2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity2 = new Intent(Mathematiques.this, Videos.class);
                startActivity(gameActivity2);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity2 = new Intent(Mathematiques.this, Synthese.class);
                startActivity(gameActivity2);
            }
        });

    }}

