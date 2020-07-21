package com.example.coronaupdate;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PakistanRetrofitClient {
    @GET("/countries/pakistan")
    Call<OurObjectDataClass> getData();
}
