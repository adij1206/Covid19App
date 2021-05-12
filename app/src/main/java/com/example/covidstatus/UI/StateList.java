package com.example.covidstatus.UI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;
import com.example.covidstatus.Adapter.CountryListAdapter;
import com.example.covidstatus.Adapter.StateListAdapter;
import com.example.covidstatus.Model.CountryData;
import com.example.covidstatus.Model.StateData;
import com.example.covidstatus.Network.RetrofitCountryCasesAll;
import com.example.covidstatus.Network.RetrofitStateData;
import com.example.covidstatus.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class StateList extends AppCompatActivity {

    private RecyclerView recyclerView;
    public List<StateData> stateDataList = new ArrayList<>();
    private StateData stateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_state);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        networkRequest();
    }

    /*private void networkRequest() {
        final RetrofitStateData stateData = new RetrofitStateData();
        Call<List<StateData>> listCall = stateData.stateApi.getAllState();
        listCall.enqueue(new Callback<List<StateData>>() {
            @Override
            public void onResponse(Call<List<StateData>> call, Response<List<StateData>> response) {
                if(response.isSuccessful()){
                    List<StateData> stateDataList = response.body();
                    Log.v("State",stateData.toString());
                    StateListAdapter stateListAdapter = new StateListAdapter(StateList.this,stateDataList);
                    recyclerView.setAdapter(stateListAdapter);
                    stateListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<StateData>> call, Throwable t) {
                Toast.makeText(StateList.this, "Error In Api Call", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void networkRequest(){
        String url  = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("regionData");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonstate = jsonArray.getJSONObject(i);

                        String name=jsonstate.getString("region");
                        String active=jsonstate.getString("activeCases");
                        String cured=jsonstate.getString("recovered");
                        String death = jsonstate.getString("deceased");
                        String total  = jsonstate.getString("totalInfected");

                        stateData=new StateData(name,active,cured,death,total);
                        stateDataList.add(stateData);
                    }

                    StateListAdapter stateListAdapter = new StateListAdapter(StateList.this,stateDataList);
                    recyclerView.setAdapter(stateListAdapter);
                    stateListAdapter.notifyDataSetChanged();



                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(StateList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
