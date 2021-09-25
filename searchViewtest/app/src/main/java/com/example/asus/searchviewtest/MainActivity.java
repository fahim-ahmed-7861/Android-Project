package com.example.asus.searchviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    SearchView searchView;

    String[] name;

    int[] img ={R.drawable.medi1,R.drawable.medi2,R.drawable.medi3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            name = getResources().getStringArray(R.array.booklist);

            listView = findViewById(R.id.listid);

            searchView = findViewById(R.id.searchid);

            final Aadapter aadapter = new Aadapter(this, getplayers());

           listView.setAdapter(aadapter);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {


                    aadapter.getFilter().filter(newText);

                    return false;
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String value = name[position];

                    Toast.makeText(MainActivity.this, value + " " + position, Toast.LENGTH_SHORT).show();


                }
            });

    }


       private ArrayList<player> getplayers () {

                player p;

           ArrayList<player> players = new ArrayList<player> ();

                for (int i = 0; i < name.length; i++) {
                    p = new player(name[i], img[i]);

                  //  players().add(p);
                    players.add(p);




                }




           return players;
        }


    @Override
    public void onBackPressed() {



    }
}
