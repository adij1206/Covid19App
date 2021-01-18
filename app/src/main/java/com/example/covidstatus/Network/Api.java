package com.example.covidstatus.Network;

import com.example.covidstatus.Model.CountryData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("all")
    Call<CountryData> getAllCases();

    @GET("countries")
    Call<List<CountryData>> getAllCountryCases();
}
