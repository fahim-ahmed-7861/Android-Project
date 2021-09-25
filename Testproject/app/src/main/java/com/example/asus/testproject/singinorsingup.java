package com.example.asus.testproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class singinorsingup extends AppCompatActivity {

    TextView textView,t1;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singinorsingup);

        textView = findViewById(R.id.text);

        t1 = findViewById(R.id.textquotes);

        Typeface mycustomfont = Typeface.createFromAsset(getAssets(),"fonts/KaushanScript-Regular.otf");

        textView.setTypeface(mycustomfont);

        Typeface T1 = Typeface.createFromAsset(getAssets(),"fonts/FingerPaint-Regular.ttf");

        t1.setTypeface(T1);

        button = findViewById(R.id.signup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent  intent= new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        getSupportActionBar().hide();

    }
}
