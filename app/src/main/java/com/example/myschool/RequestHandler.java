package com.example.myschool;


import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 *
 * Volley Singleton pattern
 *
 * <p>
 * Ex, i call Volley.newRequestQueue(context) n times => n RequestQueue will create.
 * But, i only need to use 1 RequestQueue for all apps (Activity, Fragment, Service…).
 * So, here i use Singleton Pattern for design class RequestHandler that manages RequestQueue
 * </p>
 *
 *
 */

public class RequestHandler {

    private static RequestHandler mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private RequestHandler(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized RequestHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RequestHandler(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {

            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {

        getRequestQueue().add(req);

    }
}