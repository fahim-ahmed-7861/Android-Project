package com.example.asus.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private ListView listView;

    private SearchView searchView;

     String[] countryName ;


    ArrayAdapter<String>  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listid);

        searchView = findViewById(R.id.searchid);

        countryName = getResources().getStringArray(R.array.country_name);

         adapter = new ArrayAdapter<>(this,R.layout.sample_view,R.id.textviewid,countryName);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(this);

       // searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

      // String value = countryName[position];

        String Value = adapter.getItem(position);

        Toast.makeText(MainActivity.this,Value,Toast.LENGTH_SHORT).show();


    }

    private void setupSearchView()
    {
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search Here");
    }

    @Override
    public boolean onQueryTextChange(String newText)
    {

       // if (TextUtils.isEmpty(newText)) {
        //    listView.clearTextFilter();
       // } else {
            listView.setFilterText(newText);
      //  }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }
}
