package com.example.asus.countryproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;

    private TextView textView,textViewbd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView=findViewById(R.id.imagenow);

        textView=findViewById(R.id.text);

        Bundle bundle= getIntent().getExtras();

        if(bundle!=null)
        {
            String countryname= bundle.getString("key");

            ShowDetails(countryname);
        }
    }

    void ShowDetails(String countryname)
    {
        if(countryname.equals("Bangladesh"))
        {
            imageView.setImageResource(R.drawable.bd);

            textView.setText(R.string.bdtext);
        }
        else if(countryname.equals("India"))
        {
            imageView.setImageResource(R.drawable.india);
            textView.setText(R.string.indiatext);
        }
        else if(countryname.equals("Pakistan"))
        {
            imageView.setImageResource(R.drawable.pakistan);
            textView.setText(R.string.pakistantext);
        }
    }
}
