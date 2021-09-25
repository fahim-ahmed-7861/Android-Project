package com.example.asus.customadapterpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    String[]  countryName;

    private SearchView searchView;



    int[] flags = {R.drawable.bangladesh,R.drawable.india,R.drawable.nepal,
            R.drawable.china,R.drawable.pakistan,R.drawable.srilanka,R.drawable.bahrain,
            R.drawable.armenia,R.drawable.australia,R.drawable.azerbaijan,R.drawable.bhutan,
            R.drawable.brazil,R.drawable.argentina,R.drawable.germany,
            R.drawable.belgium,R.drawable.uruguay};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listviewid);

        searchView= findViewById(R.id.searchid);

        countryName = getResources().getStringArray(R.array.countryname);

        final CustomAdapter customAdapter = new CustomAdapter (MainActivity.this,countryName,flags);

       listView.setAdapter(customAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               String value = countryName[position];

               Toast.makeText(MainActivity.this,value,LENGTH_SHORT).show();
           }
       });






    }
}
