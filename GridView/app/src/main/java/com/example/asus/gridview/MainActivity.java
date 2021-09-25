package com.example.asus.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView ;

    String[] CountryName;

    int[] flags = {R.drawable.bangladesh,R.drawable.india,R.drawable.nepal,
            R.drawable.china,R.drawable.pakistan,R.drawable.srilanka,R.drawable.bahrain,
            R.drawable.armenia,R.drawable.australia,R.drawable.azerbaijan,R.drawable.bhutan,
            R.drawable.brazil,R.drawable.argentina,R.drawable.germany,
            R.drawable.belgium,R.drawable.uruguay};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridviewid);


        CountryName = getResources().getStringArray(R.array.countryname);

        CustomAdapter customAdapter = new CustomAdapter(this,CountryName,flags);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value= CountryName[position];

                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();

            }
        });




    }
}
