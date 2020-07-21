package com.example.coronaupdate;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<OurObjectDataClass> allDataList;
    List<String> allCountryList;
    TextView totalCasesTextView;
    TextView bangladesh,india,world,pakistan,america,brazil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        bangladesh=findViewById (R.id.Bangladesh);
        india=findViewById (R.id.India);
        world=findViewById (R.id.world);
        pakistan=findViewById (R.id.Pakistan);
        america=findViewById (R.id.America);
        brazil=findViewById (R.id.BraZil);


        bangladesh.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this,Details.class);
                intent.putExtra ("value","bangladesh");
                startActivity (intent);
            }
        });
        world.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this,Details.class);
                intent.putExtra ("value","world");
                startActivity (intent);
            }
        });
        india.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this,Details.class);
                intent.putExtra ("value","india");
                startActivity (intent);
            }
        });
        pakistan.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this,Details.class);
                intent.putExtra ("value","pakistan");
                startActivity (intent);
            }
        });
        america.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this,Details.class);
                intent.putExtra ("value","america");
                startActivity (intent);
            }
        });
        brazil.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this,Details.class);
                intent.putExtra ("value","brazil");
                startActivity (intent);
            }
        });



    }
}
