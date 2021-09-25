package com.example.asus.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    private ImageView imageView;

    private TextView textView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.image);

        textView= findViewById(R.id.text);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            String countryName = bundle.getString("key");

            showdetail(countryName);
        }

    }

    void showdetail(String CountryName)
    {
        if(CountryName.equals("Bangladesh"))
        {
            imageView.setImageResource(R.drawable.bd);

            textView.setText(R.string.bdtext);
        }
        else if (CountryName.equals("India"))
        {
                imageView.setImageResource(R.drawable.india);

                textView.setText(R.string.indiatext);

        }
    }
}
