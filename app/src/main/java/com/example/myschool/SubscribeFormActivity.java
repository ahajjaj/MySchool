package com.example.myschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.content.Intent;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/*
 roles
 student=0;
 parent=1;
 teacher=2;
 */

public class SubscribeFormActivity extends AppCompatActivity {

     EditText email;
     EditText password;
     EditText gender;
     EditText FName;
     EditText LName;
     EditText age;
     String role;

     Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe_form);

        email = (EditText) findViewById(R.id.emailLog);
        password = (EditText) findViewById(R.id.passwordLog);
        LName = (EditText) findViewById(R.id.name);
        FName = (EditText) findViewById(R.id.familyName);
        gender = (EditText) findViewById(R.id.gender);
        age = (EditText) findViewById(R.id.age);
        submit= (Button) findViewById(R.id.submit);
        int whoiam = -1;
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                whoiam=extras.getInt("role");
                switch (whoiam) {
                    case 0:
                    {
                        role="0";
                    }break;
                    case 1:
                    {
                        role="1";
                    }break;
                    case 2:
                    {
                        role="2";
                    }
                }
            }
        } else {
            whoiam= (int)savedInstanceState.getSerializable("role");
        }

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                registerUser(email.getText().toString(),password.getText().toString(),gender.getText().toString(),FName.getText().toString(),LName.getText().toString(),age.getText().toString(),role);
                Intent gameActivity = new Intent(SubscribeFormActivity.this, LoginActivity.class);
                startActivity(gameActivity);
            }
        });

    }

    private void registerUser(final String mail, final String pass, final String sex, final String fname, final String lname, final String age, final String role) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Registerresponse",response.toString());
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                Log.d( " sending"     ,   mail+","+pass+","+sex+","+fname+","+lname+","+age+","+role);
                params.put("Email",mail);
                params.put("passwd", pass);
                params.put("Lname",lname);
                params.put("Fname",fname);
                params.put("gender",sex);
                params.put("age",age);
                params.put("role",role);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
            /*
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
            */
    }
}
