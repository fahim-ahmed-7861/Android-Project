package com.example.asus.progressbar;

import android.support.constraint.solver.widgets.Analyzer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AnalogClock;

public class Fahim extends AppCompatActivity {

    private AnalogClock analog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahim);



        analog=findViewById(R.id.clock);
    }
}
