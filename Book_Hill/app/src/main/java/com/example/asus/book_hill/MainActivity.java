package com.example.asus.book_hill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int p;
    private  Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        for(p=0; p<=100; p+=10)
        {
            try {
                sleep(1000);

                progressBar.setProgress(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        intent= new Intent(getApplicationContext(),Signupin.class);
       startActivity(intent);
    }
    public void onBackPressed() {

    }
}
