package com.example.asus.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Spinner spinner;

    Button button;

    TextView textView;

    String[] country_name;

    Boolean clicked=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerid);

        button = findViewById(R.id.buttonid);

        textView = findViewById(R.id.textviewid);

        country_name = getResources().getStringArray(R.array.countryname);

        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(this,R.layout.sample_layout,R.id.layouttext,country_name);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(clicked)
                    Toast.makeText(MainActivity.this,country_name[position],Toast.LENGTH_SHORT).show();

                else clicked=true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = spinner.getSelectedItem().toString();

                textView.setText(value);

                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
