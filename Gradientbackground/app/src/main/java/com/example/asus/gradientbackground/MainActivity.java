package com.example.asus.gradientbackground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView listView;

    String[] country_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listvieweid);

        country_name= getResources().getStringArray(R.array.country_name);

        ArrayAdapter<String>adapter =new ArrayAdapter<>(this,R.layout.sample_view,R.id.textid,country_name);

        listView.setAdapter(adapter);


    }
}
