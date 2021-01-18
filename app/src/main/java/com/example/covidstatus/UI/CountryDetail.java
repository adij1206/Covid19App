package com.example.covidstatus.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.covidstatus.R;

public class CountryDetail extends AppCompatActivity {

    private TextView countryName,countryCases,countryTodayCases,countryDeaths,countryTodayDeath,countryRecd,countryTodayRecd,countryActive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        countryName = (TextView) findViewById(R.id.country_name_detail);
        countryCases = (TextView) findViewById(R.id.country_cases_detail);
        countryTodayCases = (TextView) findViewById(R.id.country_today_cases_detail);
        countryDeaths = (TextView) findViewById(R.id.country_death_detail);
        countryTodayDeath = (TextView) findViewById(R.id.country_today_death_detail);
        countryRecd = (TextView) findViewById(R.id.country_recovered_detail);
        countryTodayRecd = (TextView) findViewById(R.id.country_today_recovered_detail);
        countryActive = (TextView) findViewById(R.id.country_active_detail);

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            countryName.setText("Country :" + extras.getString("name"));
            countryCases.setText("Cases :" + extras.getString("cases"));
            countryTodayCases.setText("Today Cases :" +extras.getString("todaycases"));
            countryDeaths.setText("Death :"+extras.getString("death"));
            countryTodayDeath.setText("Today Death :" +extras.getString("todayDeath"));
            countryRecd.setText("Recovered :" +extras.getString("recovered"));
            countryTodayRecd.setText("Today Recovered :" + extras.getString("todayRecovered"));
            countryActive.setText("Active :" +extras.getString("active"));
        }
    }
}
