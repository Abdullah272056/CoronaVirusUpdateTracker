package com.example.coronaupdate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AmericaRetrofitClient {
    @GET("/countries/usa")
    Call<OurObjectDataClass> getData();
}
