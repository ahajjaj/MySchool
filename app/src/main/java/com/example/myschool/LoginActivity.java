package com.example.myschool;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity  {

    private TextView tvRegister;
    private ProgressDialog pD ;
    private TextView email;
    private TextView password;
    private boolean isConnected=false;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        Button connect = (Button) findViewById(R.id.ButtonConnect);
        final TextView email= (TextView)findViewById(R.id.emailLog);
        final TextView password= (TextView)findViewById(R.id.passwordLog);
        tvRegister = findViewById(R.id.tvRegister);
        pD = new ProgressDialog(this);


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RoleActivity.class));
                finish();
            }
        });
        connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //DO SOMETHING! {RUN SOME FUNCTION ... DO CHECKS... ETC}
                Log.d(email.getText().toString() , password.getText().toString() );
                registerUser(email.getText().toString().trim(),password.getText().toString().trim());
                if(isConnected){
                    Log.d("Connection","je suis connecté");
                    pD.setMessage("welcome !");
                    pD.show();
                    Intent gameActivity = new Intent(LoginActivity.this, UserInterface.class);
                    startActivity(gameActivity);
                }else{
                    Log.d("Connection","je ne suis pas connecté");
                    pD.setMessage("retry !");
                    pD.show();
                }
            }
        });

    }
            /*connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 // Code here executes on main thread after user presses button
                Intent gameActivity = new Intent(LoginActivity.this, UserInterface.class);
                startActivity(gameActivity);
            }
        });
        */
        public void registerUser(final String mail, final String pass) {

            pD.setMessage("connecting...");
            pD.show();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_LOGIN,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            pD.dismiss();
                            Log.d("Loginresponse", response.toString());
                            try {

                                JSONObject jsonObject = new JSONObject(response);
                                Log.d("email", jsonObject.getString("Email"));
                                if (jsonObject.getString("error").equals("false")) {
                                    isConnected = true;
                                } else {
                                    isConnected = false;
                                    Log.d("mdpsent", jsonObject.getString("passwordSent"));
                                    Log.d("mdpstored", jsonObject.getString("passwordStored"));
                                }

                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            pD.hide();
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    Log.d(mail, pass);
                    params.put("Email", mail);
                    params.put("passwd", pass);
                    return params;
                }
            };
            RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
            Log.d("iSConnected", String.valueOf(isConnected));




        }
    }

