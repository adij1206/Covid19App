package com.example.covidstatus.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidstatus.Model.CountryData;
import com.example.covidstatus.Network.RetrofitCountryCasesAll;
import com.example.covidstatus.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private TextView totalCases;
    private Button trackCountry,trackIndianState;
    private CountryData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        totalCases = (TextView) findViewById(R.id.total_cases);
        trackCountry = (Button) findViewById(R.id.track_country);
        trackIndianState = (Button) findViewById(R.id.track_indian_states);

        networkRequest();

        trackCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent countryIntent = new Intent(HomeActivity.this,CountryList.class);
                startActivity(countryIntent);
            }
        });

        trackIndianState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stateIntent = new Intent(HomeActivity.this,StateList.class);
                startActivity(stateIntent);
            }
        });
    }

    private void networkRequest() {
        RetrofitCountryCasesAll casesAll = new RetrofitCountryCasesAll();
        Call<CountryData> dataCall = casesAll.api.getAllCases();
        dataCall.enqueue(new Callback<CountryData>() {
            @Override
            public void onResponse(Call<CountryData> call, Response<CountryData> response) {
                if(response.isSuccessful()){
                    data = response.body();
                    totalCases.setText(data.getCases());
                    //Testing
                    Log.v("Data",data.getCases());
                    Log.v("Data",data.getActive());
                    Log.v("Data",data.getDeaths());
                }
            }

            @Override
            public void onFailure(Call<CountryData> call, Throwable t) {
                Toast.makeText(HomeActivity.this,"Error In Api call",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
