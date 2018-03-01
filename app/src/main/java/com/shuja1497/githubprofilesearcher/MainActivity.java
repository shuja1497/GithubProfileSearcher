package com.shuja1497.githubprofilesearcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private StringRequest mStringRequest;
    private String mBASE_URL;
    private String mURL;
    private EditText mEditText;
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText_ueserName);
        mTextView = findViewById(R.id.textView_repos);
        mButton = findViewById(R.id.button_search);

        // Get a RequestQueue
//        mQueue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        mBASE_URL = "https://api.github.com/users/";
    }


    public void search(View view) {

        // clear previous searches
        clearPreviousSearches();

        // search for current repos
        searchRepos(mEditText.getText().toString());
    }

    private void searchRepos(String username) {
        mURL = mBASE_URL+username+"/repos";

        mStringRequest = new StringRequest(Request.Method.GET, mURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showRepos(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mTextView.setText(" error while calling API");
            }
        });
        // Add a request
        MySingleton.getInstance(this).addToRequestQueue(mStringRequest);

    }

    private void showRepos(String response) {
        mTextView.setText(response);
    }

    private void clearPreviousSearches() {
        mTextView.setText("");
    }
}
