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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.HashMap;

public class programming extends AppCompatActivity {

    private ListView listView;

   public static  String[] namebook,tkbook;
    private static String[] book,price;

    private SearchView searchView ;

    static  HashMap<String,String>orderlist = new  HashMap<String,String>();

    static  HashMap<String,String>Click = new  HashMap<String,String>();

    CustomAdapter adapter;


    private Button b;



    private Intent intent;

    static  Double tsum =0.0 ;



    static  StringBuilder stringBuilder = new StringBuilder();

    static  int pcountter=0,bcounter=0;


    Button button;
    int[] picture ={R.drawable.programming1,R.drawable.programming2,R.drawable.programming3,R.drawable.programming4,R.drawable.programming5,

            R.drawable.programming6 , R.drawable.programming7,R.drawable.programming8,R.drawable.programming9,R.drawable.programming10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming);

        this.setTitle("    Programming ");

        listView = findViewById(R.id.listviewid);

        book = getResources().getStringArray(R.array.programmingbook);



        price = getResources().getStringArray(R.array.programmingprice);


        adapter = new CustomAdapter(getApplicationContext(), book, price, picture);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = book[position].toString();

                String str = price[position].toString(),nuLL="";

                Object tvalue = orderlist.get(book[position]);



              if(!orderlist.containsKey(value)) {

                   orderlist.put(value,str);

                   Click.put(value,"1");

                   Toast.makeText(getApplicationContext(),value+" 1 copy ordered",Toast.LENGTH_SHORT).show();
               }

               else
               {
                   double sum1 = Double.parseDouble(str);

                  String tempp=orderlist.get(value);


                  double sum2 = Double.parseDouble(tempp);

                 double sum = sum1 + sum2;

                   String sumstr = String.valueOf(sum);

                  orderlist.put(value,sumstr);

                  int counter = Integer.parseInt(Click.get(value))+1;
                   String strcnt=String.valueOf(counter);

                   Click.put(value,strcnt);



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
            preparelist();
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

            AlertDialog.Builder alert = new AlertDialog.Builder(programming.this);

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

     static void preparelist()
     {
         stringBuilder = new StringBuilder();

         tkbook = new String[orderlist.size()+1];

         namebook = new String[orderlist.size()+1];



         tsum =0.0;

         pcountter =0;

         bcounter =0 ;

         for(String name : orderlist.keySet())
         {
             String b = name.toString();

             String v = orderlist.get(name).toString();


             tsum = tsum + Double.parseDouble(v);


             stringBuilder.append(name+ "       "+v+ " Tk\n\n");


            namebook[bcounter++]=b;
             tkbook[pcountter]=v;

             pcountter++;


         }
         String b="Total Tk :";

         String v =tsum.toString();;
         namebook[bcounter++]=b;
         tkbook[pcountter]=v;

         pcountter++;
     }
    public void onBackPressed() {

    }


}
