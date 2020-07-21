package com.example.coronaupdate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WorldRetrofitClient {
    @GET("/countries/world")
    Call<OurObjectDataClass> getData();

}
