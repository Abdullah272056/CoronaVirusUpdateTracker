package com.example.coronaupdate.retrofitClientInterface;

import com.example.coronaupdate.modelClass.OurObjectDataClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArgentinaRetrofitClient {
    @GET("/countries/argentina")
    Call<OurObjectDataClass> getData();

}
