package com.example.android.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        final TextView textView4 = (TextView)findViewById(R.id.textView4);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView6 = (TextView) findViewById(R.id.textView6);
        final TextView textView7 = (TextView) findViewById(R.id.textView7);
        final TextView textView8 = (TextView) findViewById(R.id.textView8);
        final TextView textView9 = (TextView) findViewById(R.id.textView9);
        final TextView textView10 = (TextView) findViewById(R.id.textView10);
        final TextView textView12 = (TextView) findViewById(R.id.textView12);
        final TextView textView13 = (TextView) findViewById(R.id.textView13);
        final TextView textView14 = (TextView) findViewById(R.id.textView14);
        final ImageView imageView1st = (ImageView) findViewById(R.id.imageView1st);
        final ImageView imageView2nd = (ImageView) findViewById(R.id.imageView2nd);
        final ImageView imageView3rd = (ImageView) findViewById(R.id.imageView3rd);

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "https://www.semiit.com/ranking.php";
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String name = response.getString("name");
                            String score = response.getString("score");
                            List<Integer> integerList = new ArrayList<Integer>();
                            List<String> nameList = new ArrayList<String>();
                            Intent intent = getIntent();
                            String[] separatedname = name.split(":");
                            String[] separatedscore = score.split(":");
                            for(int i=0;i<separatedname.length;i++){
                                integerList.add(Integer.parseInt(separatedscore[i]));
                                nameList.add(separatedname[i]);
                            }
                            for(int i=0;i<integerList.size();i++){
                                for(int j=i+1;j<integerList.size();j++){
                                    if(integerList.get(i) < integerList.get(j)){
                                        Collections.swap(integerList, i, j);
                                        Collections.swap(nameList,i,j);
                                    }
                                }
                            }
                            imageView1st.setImageResource(R.drawable.first);
                            imageView2nd.setImageResource(R.drawable.second);
                            imageView3rd.setImageResource(R.drawable.third);
                            textView4.setText("1. " + nameList.get(0) + "    "+ integerList.get(0));
                            textView5.setText("2. " +  nameList.get(1)  + "    "+integerList.get(1));
                            textView6.setText("3. " +  nameList.get(2)  + "    "+integerList.get(2));
                            textView7.setText("4. " +  nameList.get(3)  + "    "+integerList.get(3));
                            textView8.setText("5. " +  nameList.get(4)  + "    "+ integerList.get(4));
                            textView9.setText("6. " +  nameList.get(5)  + "    "+integerList.get(5));
                            textView10.setText("7. " +  nameList.get(6) + "    "+ integerList.get(6));
                            textView12.setText("8. " +  nameList.get(7) + "    "+ integerList.get(7));
                            textView13.setText("9. " +  nameList.get(8) + "    "+ integerList.get(8));
                            textView14.setText("10. " +  nameList.get(9) + "    "+ integerList.get(9));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(getRequest);
    }
}