package com.example.coronaupdate;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    TextView totalCase,todayCase,totalDeaths,todayDeaths,recover,totalTest, countryName;
    String value;
    BangladeshRetrofitClient ourRetrofitClient;
    WorldRetrofitClient worldRetrofitClient;
    IndiaRetrofitClient indiaRetrofitClient;
    AmericaRetrofitClient americaRetrofitClient;
    PakistanRetrofitClient pakistanRetrofitClient;
    BrazilRetrofitClient brazilRetrofitClient;



    Call<OurObjectDataClass> call;

    private static final String BASE_URL = "https://coronavirus-19-api.herokuapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_details);
        totalCase=findViewById (R.id.totalCase);
        todayCase=findViewById (R.id.todayCases);
        todayDeaths=findViewById (R.id.todayDeaths);
        totalDeaths=findViewById (R.id.totalDeaths);
        recover=findViewById (R.id.recover);
        totalTest=findViewById (R.id.totalTest);
        countryName=findViewById (R.id.CountryName);







        Retrofit retrofit=new Retrofit
                .Builder ()
                .baseUrl (BASE_URL)
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();


        String receiveData=getIntent ().getStringExtra ("value");
        if (receiveData.equals ("bangladesh")){
            ourRetrofitClient=retrofit.create (BangladeshRetrofitClient.class);
           call = ourRetrofitClient.getData ();
           getData ();
        }
        else if (receiveData.equals ("world")){
            worldRetrofitClient=retrofit.create (WorldRetrofitClient.class);
            call= worldRetrofitClient.getData ();
            getData ();

        }
        else if (receiveData.equals ("india")){
            indiaRetrofitClient=retrofit.create (IndiaRetrofitClient.class);
            call= indiaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("pakistan")){
            pakistanRetrofitClient=retrofit.create (PakistanRetrofitClient.class);
            call= pakistanRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("america")){
            americaRetrofitClient=retrofit.create (AmericaRetrofitClient.class);
            call= americaRetrofitClient.getData ();
            getData ();
        }
        else if (receiveData.equals ("brazil")){
            brazilRetrofitClient=retrofit.create (BrazilRetrofitClient.class);
            call= brazilRetrofitClient.getData ();
            getData ();
        }
        else {
            Toast.makeText (this, "Some Error", Toast.LENGTH_SHORT).show ();

        }





    }
    public void getData(){
        call.enqueue (new Callback<OurObjectDataClass> () {
            @Override
            public void onResponse(Call<OurObjectDataClass> call, Response<OurObjectDataClass> response) {
                if (response.isSuccessful ()){

//                    List<OurObjectDataClass> userList= (List<OurObjectDataClass>) response.body();
//                    int cases=  userList.get(3).getCases();
//                    totalCasesTextView.setText(String.valueOf (cases));



                    // int totalDeath=response.body ().getCases ();
                    countryName.setText(String.valueOf (response.body ().getCountry ()));
                    todayCase.setText(todayCase.getText ().toString ()+"\n"+String.valueOf (response.body ().getTodayCases ()));
                    totalCase.setText(totalCase.getText ().toString ()+"\n"+String.valueOf (response.body ().getCases ()));
                    totalDeaths.setText(totalDeaths.getText ().toString ()+"\n"+String.valueOf (response.body ().getCases ()));
                    todayDeaths.setText(todayDeaths.getText ().toString ()+"\n"+String.valueOf (response.body ().getTodayDeaths ()));
                    recover.setText(recover.getText ().toString ()+"\n"+String.valueOf (response.body ().getRecovered ()));
                    totalTest.setText(totalTest.getText ().toString ()+"\n"+String.valueOf (response.body ().getTotalTests ()));
                    //Toast.makeText (MainActivity.this, "Success", Toast.LENGTH_SHORT).show ();

                }
            }

            @Override
            public void onFailure(Call<OurObjectDataClass> call, Throwable t) {

            }
        });
    }
}
