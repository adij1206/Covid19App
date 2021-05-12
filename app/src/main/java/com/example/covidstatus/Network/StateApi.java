package com.example.covidstatus.Network;

import com.example.covidstatus.Model.StateData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StateApi {
    @GET("records/LATEST/")
    Call<List<StateData>> getAllState();
}
