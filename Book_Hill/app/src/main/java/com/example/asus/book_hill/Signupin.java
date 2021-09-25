package com.example.asus.book_hill;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signupin extends AppCompatActivity implements View.OnClickListener {

    private  TextView textView , t1 ;

    private  Button signin,signup;

    private AlertDialog.Builder alert;

    private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupin);



       Idfind();

        Typeface mycustomfont = Typeface.createFromAsset(getAssets(),"fonts/KaushanScript-Regular.otf");

        textView.setTypeface(mycustomfont);

        Typeface T1 = Typeface.createFromAsset(getAssets(),"fonts/FingerPaint-Regular.ttf");

        t1.setTypeface(T1);


        getSupportActionBar().hide();

        signup.setOnClickListener(this);

        signin.setOnClickListener(this);





        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

       void Idfind()
       {
           textView = findViewById(R.id.text);

           t1 = findViewById(R.id.textquotes);

           signin = findViewById(R.id.signin);

           signup = findViewById((R.id.signup));
       }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.signup)
        {
            intent= new Intent(getApplicationContext(),SignUp.class);
            startActivity(intent);
        }

        else if(v.getId()==R.id.signin)
        {
            intent= new Intent(getApplicationContext(),SignIn.class);
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {

       /* moveTaskToBack(true);

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);*/

        alert = new AlertDialog.Builder(Signupin.this);

        alert.setIcon(R.drawable.question);

        alert.setMessage(R.string.exit);

        alert.setTitle(R.string.title_text);

        alert.setCancelable(false);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               // finish();

                moveTaskToBack(true);

                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
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

}
