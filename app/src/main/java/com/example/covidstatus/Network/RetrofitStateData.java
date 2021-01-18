package com.example.covidstatus.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitStateData {
    Retrofit retrofit1 = new Retrofit.Builder()
            .baseUrl(Url.URL_STATE)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public StateApi stateApi = retrofit1.create(StateApi.class);
}
