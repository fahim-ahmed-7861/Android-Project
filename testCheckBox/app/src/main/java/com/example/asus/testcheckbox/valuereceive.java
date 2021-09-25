package com.example.asus.testcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.HashMap;

public class valuereceive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valuereceive);

        TextView textView;


        textView = findViewById(R.id.text);



        //   HashMap<String,Integer>hash=  new HashMap<String,Integer>();

     //   Integer s =MainActivity.hash.size();


       Boolean bool= MainActivity.hash.get("Human Physiology").equals("170");

       if(bool)textView.setText(MainActivity.book[0].toString());

      //



    }

}
