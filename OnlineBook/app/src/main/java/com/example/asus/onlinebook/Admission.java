package com.example.asus.onlinebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;



public class Admission extends AppCompatActivity {


   static HashMap<Integer,String> mp = new HashMap<Integer,String>();

   //public  static  String str = new String();

   TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        textView=findViewById(R.id.shojib);

        mp.put(3134,"Fahim");

        textView.setText(mp.get(3134));

    }
}
