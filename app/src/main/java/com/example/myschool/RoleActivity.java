package com.example.myschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.Intent;

public class RoleActivity extends AppCompatActivity {

    TextView question;
    CheckBox parent;
    CheckBox student;
    CheckBox teacher;
    int role=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        question = (TextView) findViewById(R.id.textView);

        final Button button = findViewById(R.id.parent);
        final Button button1 = findViewById(R.id.student);
        final Button button2 = findViewById(R.id.teacher);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity1 = new Intent(RoleActivity.this, SubscribeFormActivity.class);
                 role =0;
                gameActivity1.putExtra("role",role);
                startActivity(gameActivity1);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity2 = new Intent(RoleActivity.this, SubscribeFormActivity.class);
                 role =1;
                gameActivity2.putExtra("role",role);
                startActivity(gameActivity2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent gameActivity3 = new Intent(RoleActivity.this, SubscribeFormActivity.class);
                role =2;
                gameActivity3.putExtra("role",role);
                startActivity(gameActivity3);
            }
        });

    }
}
