package com.shuja1497.githubprofilesearcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private StringRequest mStringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a RequestQueue
        mQueue = MySingleton.getInstance(this.getApplicationContext()).
                getRequestQueue();


        // Add a request
        MySingleton.getInstance(this).addToRequestQueue(mStringRequest);
    }
}
