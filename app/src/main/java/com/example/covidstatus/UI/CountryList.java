package com.example.covidstatus.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.covidstatus.Adapter.CountryListAdapter;
import com.example.covidstatus.Model.CountryData;
import com.example.covidstatus.Network.RetrofitCountryCasesAll;
import com.example.covidstatus.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryList extends AppCompatActivity {

    private String countryList;
    private List<CountryData> list1;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        list1 = new ArrayList<CountryData>();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Log.v("List",list1.toString());

        networkRequest();


    }

    private void networkRequest() {
        RetrofitCountryCasesAll casesAll = new RetrofitCountryCasesAll();
        Call<List<CountryData>> countryCall = casesAll.api.getAllCountryCases();
        countryCall.enqueue(new Callback<List<CountryData>>() {
            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {
                if(response.isSuccessful()){
                    list1 = response.body();
                   // Log.v("list2",list1.toString());

                    CountryListAdapter countryListAdapter = new CountryListAdapter(CountryList.this,list1);
                    recyclerView.setAdapter(countryListAdapter);
                    countryListAdapter.notifyDataSetChanged();

                }
            }
            @Override
            public void onFailure(Call<List<CountryData>> call, Throwable t) {
                Toast.makeText(CountryList.this, "Error in API Call", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
