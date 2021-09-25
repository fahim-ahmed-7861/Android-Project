package com.example.asus.testcheckbox;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener{

    public ListView listView;
   public static String[] book,price;

   private SearchView searchView ;

    CustomAdapter adapter;


   private  Button b;

    ArrayAdapter<String> arr;




   private Intent intent;
    static HashMap<String,String>hash = new HashMap<String, String>();

   Button button;
   int[] picture ={R.drawable.medi1,R.drawable.medi2,R.drawable.medi3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lisviewid);

        book = getResources().getStringArray(R.array.booklist);

        searchView = findViewById(R.id.searchid);

        //  arr =book;


        price = getResources().getStringArray(R.array.bookprice);


          adapter = new CustomAdapter(MainActivity.this, book, price, picture);


        listView.setAdapter(adapter);

        listView.setTextFilterEnabled(true);

        setupSearchView();




      /* searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //   arr.getFilter().filter(newText);

                listView.setFilterText(newText);


                return false;
            }
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = book[position].toString();

                String str = price[position];

                //int p = Integer.valueOf(str);

                hash.put(value, str);


            }
        });





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

        //if (TextUtils.isEmpty(newText)) {
         //   listView.clearTextFilter();
       // } else {
        //    adapter.getF.setFilterText(newText);




       // }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }


}


