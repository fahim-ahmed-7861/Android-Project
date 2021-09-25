package com.example.asus.cardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView Schoolcardview,RestrurantCardview,HospitalCardview,AirportCardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FINDID();

        SetActionListenter();
    }

    private void FINDID()
    {
        Schoolcardview = findViewById(R.id.Schoolcarviewid);

        RestrurantCardview = findViewById(R.id.Restrurantcarviewid);

        HospitalCardview = findViewById(R.id.hospitalcarviewid);

        AirportCardview = findViewById(R.id.AirportCardid);
    }

    private  void SetActionListenter()
    {
        Schoolcardview.setOnClickListener(this);

        RestrurantCardview.setOnClickListener(this);

        HospitalCardview.setOnClickListener(this);

        AirportCardview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.AirportCardid)
        {
            Intent intent = new Intent(MainActivity.this,Airport.class);

            startActivity(intent);
        }
        else if(v.getId()==R.id.Schoolcarviewid)
        {
            Intent intent = new Intent(MainActivity.this,School.class);

            startActivity(intent);
        }
        else if(v.getId()==R.id.Restrurantcarviewid)
        {
            Intent intent = new Intent(MainActivity.this,Restrurant.class);

            startActivity(intent);
        }
        else if(v.getId()==R.id.hospitalcarviewid)
        {
            Intent intent = new Intent(MainActivity.this,Hospital.class);

            startActivity(intent);
        }

    }
}
