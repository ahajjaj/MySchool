package com.example.myschool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Synthese extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.synthese);
    }}