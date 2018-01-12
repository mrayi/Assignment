package com.example.android.assignment;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {
    private Map<String, String> params;
    private EditText yourName;
    private TextView tvScore;
    private String name, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        yourName = findViewById(R.id.editText);
        tvScore = findViewById(R.id.tvScore);
        Bundle extras = getIntent().getExtras();
        score = extras.getString("score");
        String temp = "Score: " + score;
        tvScore.setText(temp);
    }

    public void onClick(View v) {
        // Creating Volley RequestQueue.
        RequestQueue requestQueue;
        // Creating Progress dialog.
        final ProgressDialog progressDialog;
        String ADD_SCORE_URL = "https://www.semiit.com/AddScore.php";
        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(ResultActivity.this);
        progressDialog = new ProgressDialog(ResultActivity.this);
        name = yourName.getText().toString().trim();
        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ADD_SCORE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing response message coming from server.
                        Toast.makeText(ResultActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        // Showing error message if something goes wrong.
                        Toast.makeText(ResultActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                // Adding All values to Params.
                params.put("name", name);
                params.put("score", score);
                return params;
            }
        };
        // Creating RequestQueue.
        requestQueue = Volley.newRequestQueue(ResultActivity.this);
        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
        finish();
    }
}
