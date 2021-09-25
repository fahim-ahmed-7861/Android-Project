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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Medical extends AppCompatActivity {

    private ListView listView;
    private  String[] book,price;

    CustomAdapter adapter;


    private Button b;



    private Intent intent;


    Button button;
    int[] picture ={R.drawable.md1,R.drawable.md2,R.drawable.md3,R.drawable.md4,R.drawable.md5,

            R.drawable.md6 , R.drawable.md7,R.drawable.md8,R.drawable.md9,R.drawable.md10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        listView = findViewById(R.id.listviewmedi);

        this.setTitle("      Medical");

        book = getResources().getStringArray(R.array.mdbook);


        price = getResources().getStringArray(R.array.mdprice);


        adapter = new CustomAdapter(getApplicationContext(), book, price, picture);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = book[position].toString();

                String str = price[position].toString(), nuLL = "";

                Object tvalue = programming.orderlist.get(book[position]);


                if (!programming.orderlist.containsKey(value)) {

                    programming.orderlist.put(value, str);

                    programming.Click.put(value,"1");

                    Toast.makeText(getApplicationContext(),value+" 1 copy ordered",Toast.LENGTH_SHORT).show();
                } else {
                    double sum1 = Double.parseDouble(str);

                    String tempp = programming.orderlist.get(value);


                    double sum2 = Double.parseDouble(tempp);

                    double sum = sum1 + sum2;

                    String sumstr = String.valueOf(sum);

                    programming.orderlist.put(value, sumstr);


                    int counter = Integer.parseInt(programming.Click.get(value))+1;
                    String strcnt=String.valueOf(counter);

                    programming.Click.put(value,strcnt);



                    Toast.makeText(getApplicationContext(),value+" "+strcnt+ "copy ordered",Toast.LENGTH_SHORT).show();
                }


            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.cart)
        {
            programming.preparelist();
            intent = new Intent(getApplicationContext(),Order.class);
            //intent.putExtra("key","book");
            startActivity(intent);
        }

        else if(item.getItemId()==android.R.id.home)
        {
            intent = new Intent(getApplicationContext(),Booksection.class);
            //intent.putExtra("key","book");
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.aboutus)
        {
            intent = new Intent(getApplicationContext(),Aboutus.class);
            //intent.putExtra("key","book");
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.share)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("text/plain");

            String subject="Book Hill";

            String body="This is an online book ordering app";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);

            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent,"Share "));
        }
        else if(item.getItemId()==R.id.logout)
        {

            AlertDialog.Builder alert = new AlertDialog.Builder(Medical.this);

            alert.setIcon(R.drawable.question);

            alert.setMessage("Do you want to logout ?");

            alert.setTitle("Lgout");

            alert.setCancelable(false);

            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent(getApplicationContext(),SignIn.class);
                    //intent.putExtra("key","book");
                    startActivity(intent);
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();



        }


        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {

    }



}
