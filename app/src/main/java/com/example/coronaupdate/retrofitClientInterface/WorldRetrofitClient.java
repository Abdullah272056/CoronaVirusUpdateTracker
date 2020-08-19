package com.example.coronaupdate.retrofitClientInterface;

import com.example.coronaupdate.modelClass.OurObjectDataClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WorldRetrofitClient {
    @GET("/countries/world")
    Call<OurObjectDataClass> getData();

}
