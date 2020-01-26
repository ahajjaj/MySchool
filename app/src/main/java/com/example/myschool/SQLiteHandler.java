package com.example.myschool;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=1;
    private static final String DATABSE_NAME="MOOC_database";
    private static final String TABLE_LOGIN = "user";

    private static final String KEY_ID ="user_Id", KEY_EMAIL = "email", KEY_PASSWORD="password";


    public SQLiteHandler(Context context){
            super(context,DATABSE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

