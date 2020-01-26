package com.example.myschool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class CourseFragment extends Fragment {

    private String[] listLevels=null;
    public CourseFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_course, container, false);
        ListView listView=(ListView) view.findViewById(R.id.listCourses);
        //get the items of the list
        //getLevels();
        /*
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
            getActivity(),
            andoird.R.layout.simple_list_item_1,
            listLevels
            );
        */
        return inflater.inflate(R.layout.fragment_course, container, false);
    }
/*
    public String[] getLevels(){

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Constants.URL_LOGIN,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONObject jsonObject = new JSONObject();

                            } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                     }
                });
            RequestHandler.getInstance(this).addToRequestQueue(request);
            return listLevels;
        }
*/
}

