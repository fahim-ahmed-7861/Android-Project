package com.example.asus.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView i1,i2,i3,i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i1=findViewById(R.id.ii1);
        i2=findViewById(R.id.ii2);
        i3=findViewById(R.id.ii3);
        i4=findViewById(R.id.ii4);

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.ii1)
        {
          i1.setVisibility(View.GONE);
          i2.setVisibility(View.VISIBLE);
        }

        else  if(v.getId()==R.id.ii2)
        {
            i2.setVisibility(View.GONE);
            i3.setVisibility(View.VISIBLE);
        }

        else  if(v.getId()==R.id.ii3)
        {
            i3.setVisibility(View.GONE);
            i4.setVisibility(View.VISIBLE);
        }
        else  if(v.getId()==R.id.ii4)
        {
            i4.setVisibility(View.GONE);
            i1.setVisibility(View.VISIBLE);
        }
    }
}
