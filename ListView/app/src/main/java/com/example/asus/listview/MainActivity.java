package com.example.asus.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        listView=findViewById(R.id.Listviewid);

        final String[] countryName = getResources().getStringArray(R.array.country_name);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.textview,countryName);


        listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               String value = countryName[position];

               Toast.makeText(MainActivity.this,value+" "+position,Toast.LENGTH_SHORT).show();

               intent = new Intent(MainActivity.this,Details.class);


                    intent.putExtra("key",value);

                    startActivity(intent);


           }
       });

    }
}
