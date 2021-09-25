package com.example.asus.feddback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class Feedbackactivity extends AppCompatActivity implements View.OnClickListener {

    private Button sent,clear;
    private EditText feedback,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackactivity);

        name = findViewById(R.id.name);

        feedback=findViewById(R.id.feedback);

        sent=findViewById(R.id.send);

        clear= findViewById(R.id.clear);


        sent.setOnClickListener(this);

        clear.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        try{

            String Name=name.getEditableText().toString() , msg=feedback.getEditableText().toString();




            if(v.getId()==R.id.send)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"shojiblm6@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");

                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+Name+"\nMessage: "+msg);

                startActivity(Intent.createChooser(intent,"Feddback with"));


            }

            else if(v.getId()==R.id.clear)
            {
                name.setText("");

                feedback.setText("");
            }

        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Exception "+e,Toast.LENGTH_SHORT).show();
        }



    }
}
