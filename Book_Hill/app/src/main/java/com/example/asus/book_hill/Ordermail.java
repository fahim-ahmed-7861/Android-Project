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
import android.widget.EditText;
import android.widget.Toast;

public class Ordermail extends AppCompatActivity implements View.OnClickListener{

    private Button sent,clear;
    private EditText feedback,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordermail);

        this.setTitle("     Order Information");

        name = findViewById(R.id.name);

        feedback=findViewById(R.id.feedback);

        sent=findViewById(R.id.send);

        clear= findViewById(R.id.clear);


        sent.setOnClickListener(this);

        clear.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.booksection_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {

           ;this.finish();

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

            AlertDialog.Builder alert = new AlertDialog.Builder(Ordermail.this);

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
    public void onClick(View v) {


        try {

            String Name = name.getEditableText().toString(), msg = feedback.getEditableText().toString();

            if (name.equals("") || msg.equals(""))
            {
                Toast.makeText(getApplicationContext(),"Please fill up the form",Toast.LENGTH_LONG).show();
            }




           else if(v.getId()==R.id.send)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"shojiblm6@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT,"Order From Bookhill");

                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+Name+"\n\nAdress :"+msg+"\n\nOrder List : \n\n"+programming.stringBuilder+"\n\nTotal Tk : "+programming.tsum);

                startActivity(Intent.createChooser(intent,"Feddback with"));

                Toast.makeText(getApplicationContext(),"You will get your books within 3 or 4 working days.",Toast.LENGTH_SHORT).show();


            }

            else if(v.getId()==R.id.clear)
            {
                name.setText("");

                feedback.setText("");
            }

        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Exception "+e,Toast.LENGTH_SHORT).show();
        }



    }

    public void onBackPressed() {

    }
}
