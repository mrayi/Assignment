package com.example.android.assignment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
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
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        yourName = findViewById(R.id.editText);
        tvScore = findViewById(R.id.tvScore);
        Bundle extras = getIntent().getExtras();
        String temp = "Score: " + extras.getString("score");
        tvScore.setText(temp);
        return super.onCreateView(name, context, attrs);
    }

    public void onClick(View v) {
        String REGISTER_REQUEST_URL = "https://www.semiit.com/AddScore.php";
        StringRequest addScoreRequest = new StringRequest(
                Request.Method.POST,
                REGISTER_REQUEST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            int success = jsonResponse.getInt("success");
                            String message = jsonResponse.getString("message");
                            AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);
        params = new HashMap<>();
        params.put("name", yourName.getText().toString());
        params.put("score", score + "");
        RequestQueue queue = Volley.newRequestQueue(ResultActivity.this);
        queue.add(addScoreRequest);
        finish();
    }

    public Map<String, String> getParams() {
        return params;
    }
}
