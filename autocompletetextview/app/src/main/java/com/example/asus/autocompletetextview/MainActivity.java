package com.example.asus.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView auto;

    String[] countrynamne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto =findViewById(R.id.auto);

        countrynamne = getResources().getStringArray(R.array.country_name);

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,countrynamne);
        auto.setThreshold(1);
        auto.setAdapter(adapter);

        auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Value= countrynamne[position];

                Toast.makeText(getApplicationContext(),Value,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
