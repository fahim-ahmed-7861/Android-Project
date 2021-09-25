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

public class Booksection extends AppCompatActivity implements  View.OnClickListener{

    private Button islamic,mediacal,admission,story,liberation,programming,school;

    private AlertDialog.Builder  alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksection);

        this.setTitle("      Book Section");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setFind();

        setClick();
    }
    public void onBackPressed() {

       /* moveTaskToBack(true);

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);*/



    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.booksection_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {

            alert = new AlertDialog.Builder(Booksection.this);

            alert.setIcon(R.drawable.question);

            alert.setMessage("Do you want to logout ?");

            alert.setTitle("Lgout");

            alert.setCancelable(false);

            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                   Intent intent = new Intent(getApplicationContext(),Signupin.class);
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
        else if(item.getItemId()==R.id.aboutus)
        {
           Intent intent = new Intent(getApplicationContext(),Aboutus.class);
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

            AlertDialog.Builder alert = new AlertDialog.Builder(Booksection.this);

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
    void setFind()
    {
        islamic=findViewById(R.id.islamic);

        admission=findViewById(R.id.admission);

        story=findViewById(R.id.story);

        liberation=findViewById(R.id.Liberation);

        programming=findViewById(R.id.programming);

        mediacal=findViewById(R.id.medical);

        school=findViewById(R.id.schoolclg);
    }

    void setClick()
    {
        islamic.setOnClickListener(this);

        admission.setOnClickListener(this);

        story.setOnClickListener(this);

        liberation.setOnClickListener(this);

        programming.setOnClickListener(this);

        mediacal.setOnClickListener(this);

        school.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        if(v.getId()==R.id.schoolclg)
        {
            intent = new Intent(getApplicationContext(),SchoolClg.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }

        else if(v.getId()==R.id.islamic)
        {
            intent = new Intent(getApplicationContext(),IslamiBook.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }

        else if(v.getId()==R.id.programming)
        {
            intent = new Intent(getApplicationContext(),programming.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }


        else if(v.getId()==R.id.Liberation)
        {
            intent = new Intent(getApplicationContext(),Liberation.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }

        else if(v.getId()==R.id.story)
        {
            intent = new Intent(getApplicationContext(),Storry.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }
        else if(v.getId()==R.id.admission)
        {
            intent = new Intent(getApplicationContext(),Admission.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }



        else if(v.getId()==R.id.medical)
        {
            intent = new Intent(getApplicationContext(),Medical.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }


    }
}
