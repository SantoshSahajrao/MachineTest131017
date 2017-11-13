package com.example.ravi.machinetest13_10_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    ArrayList<Data> marrylist;
    RecyclerView mRecylerView;
    RecyAdpter mRecyAdpter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecylerView = findViewById(R.id.xRey);
        marrylist = new ArrayList<>();

        mRecyAdpter = new RecyAdpter(marrylist,MainActivity.this);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=18.509118,73.832644&radius=500&types=cafe&name=cafe&key=AIzaSyAuGEGHwpBK0iPt0Qxp_2s_vsVfbvDfH28", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray mresulte = response.getJSONArray("results");
                    for (int i =0; i<=mresulte.length();i++)
                    {

                        Data data = new Data();
                        JSONObject jsonObject = mresulte.getJSONObject(i);
                        JSONObject mgeometry = jsonObject.getJSONObject("geometry");
                        JSONObject mLocation = mgeometry.getJSONObject("location");

                        data.lat = mLocation.getDouble("lat");
                        data.lao = mLocation.getDouble("lng");
                        data.Icon = jsonObject.getString("icon");
                        data.mName = jsonObject.getString("name");
                        data.mAddress = jsonObject.getString("vicinity");
                        data.mRating = jsonObject.getInt("rating");
                        marrylist.add(data);
                        mRecyAdpter.notifyDataSetChanged();


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecylerView.setAdapter(mRecyAdpter);
        mRecylerView.setLayoutManager(linearLayoutManager);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);

        return true;






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.xmap)
        {
            Intent intent = new Intent(MainActivity.this,MapsActivity.class);
            intent.putExtra("Re",marrylist);
            startActivity(intent);


        }


        return true;
    }
}
