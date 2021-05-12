package com.example.covidstatus.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.covidstatus.R;

public class StateDetail extends AppCompatActivity {

    private TextView stateName,stateCases,stateActiveCases,stateDeaths,stateRecovered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_detail);

        stateName = findViewById(R.id.state_name_detail);
        stateActiveCases = findViewById(R.id.state_active_detail);
        stateDeaths = findViewById(R.id.state_death_detail);
        stateRecovered = findViewById(R.id.state_recovered_detail);
        stateCases= findViewById(R.id.state_total_detail);

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            stateName.setText("State: "+extras.getString("name"));
            stateActiveCases.setText("Active Cases: "+extras.getString("activecases"));
            stateDeaths.setText("Total Death: "+extras.getString("death"));
            stateRecovered.setText("Total Recovered: "+extras.getString("recovered"));
            stateCases.setText("Total Cases: "+extras.getString("cases"));
        }
    }
}