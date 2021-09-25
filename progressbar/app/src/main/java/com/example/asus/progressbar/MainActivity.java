package com.example.asus.progressbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar ;

    private Intent intent;

    int p=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //  getSupportActionBar().hide();
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
        for(p=0; p<=100; p+=20)
        {
            try {
                sleep(1000);

                progressBar.setProgress(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        intent= new Intent(MainActivity.this,Fahim.class);
        startActivity(intent);
    }
}
