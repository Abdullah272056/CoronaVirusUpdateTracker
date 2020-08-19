package com.example.coronaupdate.activity;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coronaupdate.modelClass.OurObjectDataClass;
import com.example.coronaupdate.R;
import com.example.coronaupdate.retrofitClientInterface.AfghanistanRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.AmericaRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.ArgentinaRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.AustraliaRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.BangladeshRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.BrazilRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.CanadaRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.ChinaRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.EnglandRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.IndiaRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.IranRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.ItalyRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.PakistanRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.SrilankaRetrofitClient;
import com.example.coronaupdate.retrofitClientInterface.WorldRetrofitClient;

import java.util.concurrent.TimeUnit;

public class Details extends AppCompatActivity {


    ProgressBar progressBar;
    TextView countryName,totalCase,todayCase,totalDeaths,todayDeaths,
            recover,active,critical,casePerMillion,deathsPerMillion,
            totalTest,testPerMillion;
    BangladeshRetrofitClient ourRetrofitClient;
    WorldRetrofitClient worldRetrofitClient;
    IndiaRetrofitClient indiaRetrofitClient;
    AmericaRetrofitClient americaRetrofitClient;
    PakistanRetrofitClient pakistanRetrofitClient;
    BrazilRetrofitClient brazilRetrofitClient;
    AfghanistanRetrofitClient afghanistanRetrofitClient;
    AustraliaRetrofitClient australiaRetrofitClient;
    ArgentinaRetrofitClient argentinaRetrofitClient;
    CanadaRetrofitClient canadaRetrofitClient;
    ChinaRetrofitClient chinaRetrofitClient;
    EnglandRetrofitClient englandRetrofitClient;
    IranRetrofitClient iranRetrofitClient;
    ItalyRetrofitClient italyRetrofitClient;
    SrilankaRetrofitClient srilankaRetrofitClient;

    Call<OurObjectDataClass> call;

    private static final String BASE_URL = "https://coronavirus-19-api.herokuapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_details);
        countryName=findViewById (R.id.CountryName);
        totalCase=findViewById (R.id.totalCase);
        todayCase=findViewById (R.id.todayCases);
        todayDeaths=findViewById (R.id.todayDeaths);
        totalDeaths=findViewById (R.id.totalDeaths);
        recover=findViewById (R.id.recover);
        active=findViewById (R.id.active);
        critical=findViewById (R.id.critical);
        casePerMillion=findViewById (R.id.casePerMillion);
        deathsPerMillion=findViewById (R.id.deathsPerMillion);
        totalTest=findViewById (R.id.totalTest);
        testPerMillion=findViewById (R.id.testPerMillion);

        progressBar=findViewById (R.id.progressBar);

        Retrofit retrofit= getRetrofit();

        String receiveData=getIntent ().getStringExtra ("value");
        if (receiveData.equals ("Bangladesh")){
            ourRetrofitClient=retrofit.create (BangladeshRetrofitClient.class);
           call = ourRetrofitClient.getData ();
           getData ();
        }
        else if (receiveData.equals ("World")){
            worldRetrofitClient=retrofit.create (WorldRetrofitClient.class);
            call= worldRetrofitClient.getData ();
            getData ();

        }
        else if (receiveData.equals ("India")){
            indiaRetrofitClient=retrofit.create (IndiaRetrofitClient.class);
            call= indiaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Pakistan")){
            pakistanRetrofitClient=retrofit.create (PakistanRetrofitClient.class);
            call= pakistanRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("America")){
            americaRetrofitClient=retrofit.create (AmericaRetrofitClient.class);
            call= americaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Brazil")){
            brazilRetrofitClient=retrofit.create (BrazilRetrofitClient.class);
            call= brazilRetrofitClient.getData ();
            getData ();
        }else if (receiveData.equals ("Afghanistan")){
            afghanistanRetrofitClient=retrofit.create (AfghanistanRetrofitClient.class);
            call= afghanistanRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Argentina")){
            argentinaRetrofitClient=retrofit.create (ArgentinaRetrofitClient.class);
            call= argentinaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Australia")){
            australiaRetrofitClient=retrofit.create (AustraliaRetrofitClient.class);
            call= australiaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Canada")){
            canadaRetrofitClient=retrofit.create (CanadaRetrofitClient.class);
            call= canadaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("China")){
            chinaRetrofitClient=retrofit.create (ChinaRetrofitClient.class);
            call= chinaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("England")){
            englandRetrofitClient=retrofit.create (EnglandRetrofitClient.class);
            call= englandRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Iran")){
            iranRetrofitClient=retrofit.create (IranRetrofitClient.class);
            call= iranRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Italy")){
            italyRetrofitClient=retrofit.create (ItalyRetrofitClient.class);
            call= italyRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("Srilanka")){
            srilankaRetrofitClient=retrofit.create (SrilankaRetrofitClient.class);
            call= srilankaRetrofitClient.getData ();
            getData ();
        }
        else {
            Toast.makeText (this, "Some Error", Toast.LENGTH_SHORT).show ();

        }

    }

    private Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .callTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        Retrofit retrofit=new Retrofit
                .Builder ()
                .baseUrl (BASE_URL)
                .addConverterFactory (GsonConverterFactory.create ())
                .client (httpClient.build ())
                .build ();
        return retrofit;
    }

    public void getData(){
        call.enqueue (new Callback<OurObjectDataClass> () {
            @Override
            public void onResponse(Call<OurObjectDataClass> call, Response<OurObjectDataClass> response) {
                if (response.isSuccessful ()){
                    countryName.setText(String.valueOf (response.body ().getCountry ()));
                    todayCase.setText(todayCase.getText ().toString ()+"\n"+String.valueOf (response.body ().getTodayCases ()));
                    totalCase.setText(totalCase.getText ().toString ()+"\n"+String.valueOf (response.body ().getCases ()));
                    totalDeaths.setText(totalDeaths.getText ().toString ()+"\n"+String.valueOf (response.body ().getDeaths ()));
                    todayDeaths.setText(todayDeaths.getText ().toString ()+"\n"+String.valueOf (response.body ().getTodayDeaths ()));
                    recover.setText(recover.getText ().toString ()+"\n"+String.valueOf (response.body ().getRecovered ()));
                    active.setText(active.getText ().toString ()+"\n"+String.valueOf (response.body ().getActive ()));
                    critical.setText(critical.getText ().toString ()+"\n"+String.valueOf (response.body ().getCritical ()));
                    casePerMillion.setText(casePerMillion.getText ().toString ()+"\n"+String.valueOf (response.body ().getCasesPerOneMillion ()));
                    deathsPerMillion.setText(deathsPerMillion.getText ().toString ()+"\n"+String.valueOf (response.body ().getDeathsPerOneMillion ()));
                    totalTest.setText(totalTest.getText ().toString ()+"\n"+String.valueOf (response.body ().getTotalTests ()));
                    testPerMillion.setText(testPerMillion.getText ().toString ()+"\n"+String.valueOf (response.body ().getTestsPerOneMillion ()));
                    //Toast.makeText (MainActivity.this, "Success", Toast.LENGTH_SHORT).show ();
                        progressBar.onVisibilityAggregated (false);
                }else {
                  //  countryName.setText ("Failed");
                }

            }

            @Override
            public void onFailure(final Call<OurObjectDataClass> call, final Throwable t) {
                countryName.setText ("Connection Failed");
                progressBar.onVisibilityAggregated (false);
                call.clone ();


            }
        });

    }


}
