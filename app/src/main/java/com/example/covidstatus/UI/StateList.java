package com.example.covidstatus.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.covidstatus.Adapter.CountryListAdapter;
import com.example.covidstatus.Adapter.StateListAdapter;
import com.example.covidstatus.Model.CountryData;
import com.example.covidstatus.Model.StateData;
import com.example.covidstatus.Network.RetrofitCountryCasesAll;
import com.example.covidstatus.Network.RetrofitStateData;
import com.example.covidstatus.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateList extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_state);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        networkRequest();
    }

    private void networkRequest() {
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
    }
}
