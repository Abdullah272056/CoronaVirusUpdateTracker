package com.example.coronaupdate.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.coronaupdate.R;
import com.example.coronaupdate.modelClass.OurObjectDataClass;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
     String[]countryName;

    List<OurObjectDataClass> allDataList;
    List<String> allCountryList;
    TextView totalCasesTextView;
//TextView bangladesh,india,world,pakistan,america,brazil;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        listView=findViewById(R.id.listViewId);

       countryName=getResources().getStringArray(R.array.country_name);
        adapter=new ArrayAdapter<>(MainActivity.this,R.layout.listview_row_design,
                R.id.list_row_id,countryName);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value=countryName[position];
                Intent intent =new Intent (MainActivity.this, Details.class);
                intent.putExtra ("value",value);
                startActivity (intent);
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater ();
        menuInflater.inflate(R.menu.menu_layout,menu);

        MenuItem menuItem=menu.findItem(R.id.searchViewID);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener (new SearchView.OnQueryTextListener () {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


        return true;
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Please confirm");
        builder.setMessage("Do you want to exit this app?");
        builder.setCancelable(true);
        builder.setPositiveButton ("Yes", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText (MainActivity.this, "thank you", Toast.LENGTH_SHORT).show ();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
