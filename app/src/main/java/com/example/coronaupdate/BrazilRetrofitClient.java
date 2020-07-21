package com.example.coronaupdate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrazilRetrofitClient {
    @GET("/countries/brazil")
    Call<OurObjectDataClass> getData();
}
