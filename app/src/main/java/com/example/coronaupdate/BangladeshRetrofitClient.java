package com.example.coronaupdate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BangladeshRetrofitClient {

    @GET("/countries/bangladesh")
    Call<OurObjectDataClass> getData();





}
