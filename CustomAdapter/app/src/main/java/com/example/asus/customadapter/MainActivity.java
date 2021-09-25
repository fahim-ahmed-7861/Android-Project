package com.example.asus.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private  String[] country_name;

    private  int[] flags = {R.drawable.bangladesh,R.drawable.india,R.drawable.nepal,
    R.drawable.china,R.drawable.pakistan,R.drawable.sri_lanka,R.drawable.bahrain,
            R.drawable.armenia,R.drawable.australia,R.drawable.azerbaijan,R.drawable.bhutan,
            R.drawable.brazil,R.drawable.argentina,R.drawable.germany,
            R.drawable.belgium,R.drawable.uruguay};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_name = getResources().getStringArray(R.array.country_name);
        listView=findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter (MainActivity.this,country_name,flags);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = country_name[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
