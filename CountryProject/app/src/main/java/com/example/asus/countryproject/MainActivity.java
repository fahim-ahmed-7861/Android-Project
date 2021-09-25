package com.example.asus.countryproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bangladesh,pakistan,india;

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangladesh=findViewById(R.id.bangladesh);

        india=findViewById(R.id.india);

        pakistan=findViewById(R.id.pakistan);

        bangladesh.setOnClickListener(this);

        india.setOnClickListener(this);

        pakistan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        intent=new Intent(MainActivity.this,ProfileActivity.class);

        if(v.getId()==R.id.bangladesh)
        {
            intent.putExtra("key","Bangladesh");
        }

        else if(v.getId()==R.id.india)
        {
            intent.putExtra("key","India");
        }
       else if(v.getId()==R.id.pakistan)
        {
            intent.putExtra("key","Pakistan");
        }

        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog.Builder alert;

        alert = new AlertDialog.Builder(MainActivity.this);

        alert.setIcon(R.drawable.exiticon);

        alert.setMessage(R.string.exit);

        alert.setTitle(R.string.title);

        alert.setCancelable(false);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
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
