package com.example.asus.book_hill;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {

    TextView t1;

    private ListView listView ;

    private  Customorder adapter;



   //private Button clr,border;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        this.setTitle("       Order Book");
       listView = findViewById(R.id.listviewid1);






        adapter = new Customorder(getApplicationContext(), programming.namebook,programming.tkbook);


        listView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.order_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       if(item.getItemId()==R.id.ok)
        {

            programming.preparelist();

            if(programming.tkbook.length==1)
            {
                Toast.makeText(getApplicationContext(),"Please select minimum one item",Toast.LENGTH_LONG).show();
            }
            else{
           Intent intent1 = new Intent(getApplicationContext(),Ordermail.class);
            //intent.putExtra("key","book");
            startActivity(intent1);}
        }

        else if(item.getItemId()==R.id.clear)
        {
            programming.orderlist.clear();

            programming.preparelist();

            adapter = new Customorder(getApplicationContext(), programming.namebook,programming.tkbook);

            listView.setAdapter(adapter);
        }
       else if(item.getItemId()==android.R.id.home)
       {
         this.finish();
       }



        return super.onOptionsItemSelected(item);
    }


    public void onBackPressed() {

    }


}
