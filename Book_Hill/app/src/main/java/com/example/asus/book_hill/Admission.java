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

public class Admission extends AppCompatActivity {

    private ListView listView1;
    private  String[] book1,price1;

    private AlertDialog.Builder  alert;

    private  CustomAdapter adapter1;


    private Button b;



    private Intent intent1;

    private  int[] picture1 ={R.drawable.adm1,R.drawable.adm2,R.drawable.adm3,R.drawable.adm4,R.drawable.adm5,

            R.drawable.adm6 , R.drawable.adm7,R.drawable.adm8,R.drawable.adm9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        listView1 = findViewById(R.id.listviewadd);

        this.setTitle("      Admission");

        book1 = getResources().getStringArray(R.array.admissionbook);


        price1 = getResources().getStringArray(R.array.admissionprice);


        adapter1 = new CustomAdapter(getApplicationContext(), book1, price1, picture1);


        listView1.setAdapter(adapter1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = book1[position].toString();

                String str = price1[position].toString(), nuLL = "";

                Object tvalue = programming.orderlist.get(book1[position]);


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
            intent1 = new Intent(getApplicationContext(),Order.class);
            //intent.putExtra("key","book");
            startActivity(intent1);
        }

        else if(item.getItemId()==android.R.id.home)
        {

            intent1 = new Intent(getApplicationContext(),Booksection.class);
            //intent.putExtra("key","book");
            startActivity(intent1);
        }
               else if(item.getItemId()==R.id.aboutus)
        {
            intent1 = new Intent(getApplicationContext(),Aboutus.class);
            //intent.putExtra("key","book");
            startActivity(intent1);
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

            alert = new AlertDialog.Builder(Admission.this);

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

    @Override
    public void onBackPressed() {

    }
}
