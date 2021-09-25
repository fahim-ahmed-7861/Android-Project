package com.example.asus.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class WelcomeScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    int p;
    private  Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        getSupportActionBar().hide();



        progressBar = findViewById(R.id.progressbarid);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
            }
        });
        thread.start();

    }

    public  void dowork()
    {
        for(p=0; p<=100; p+=50)
        {
            try {
                sleep(1000);

                progressBar.setProgress(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        intent= new Intent(getApplicationContext(),singinorsingup.class);
        startActivity(intent);
    }



}
