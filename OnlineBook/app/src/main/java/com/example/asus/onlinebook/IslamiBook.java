package com.example.asus.onlinebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IslamiBook extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islami_book);

        textView=findViewById(R.id.shojib1);

        String str= Admission.mp.get(3134);


       //textView.setText(str);







    }
}
