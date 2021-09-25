package com.example.asus.spinnerwithonitemselected;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    String[] country_name,population;

    Boolean isselected=false;

    int[] flags = {R.drawable.bangladesh,R.drawable.india,R.drawable.nepal,
            R.drawable.china,R.drawable.pakistan,R.drawable.srilanka,R.drawable.bahrain,
            R.drawable.armenia,R.drawable.australia,R.drawable.azerbaijan,R.drawable.bhutan,
            R.drawable.brazil,R.drawable.argentina,R.drawable.germany,
            R.drawable.belgium,R.drawable.uruguay};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById( R.id.spinnerid);

        country_name = getResources().getStringArray(R.array.countryname);

        population = getResources().getStringArray(R.array.population);


        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,country_name,population,flags);

        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(isselected)
                    Toast.makeText(getApplicationContext(),country_name[position],Toast.LENGTH_SHORT).show();


                else
                    isselected=true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}
