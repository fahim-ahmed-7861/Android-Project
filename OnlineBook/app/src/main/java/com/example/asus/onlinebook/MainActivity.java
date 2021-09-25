
package com.example.asus.onlinebook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button islamic,mediacal,admission,story,liberation,programming,school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFind();

        setClick();


    }

    void setFind()
    {
        islamic=findViewById(R.id.islamic);

        admission=findViewById(R.id.admission);

        story=findViewById(R.id.story);

        liberation=findViewById(R.id.Liberation);

        programming=findViewById(R.id.programming);

        mediacal=findViewById(R.id.medical);

        school=findViewById(R.id.schoolclg);
    }

    void setClick()
    {
        islamic.setOnClickListener(this);

        admission.setOnClickListener(this);

        story.setOnClickListener(this);

        liberation.setOnClickListener(this);

        programming.setOnClickListener(this);

        mediacal.setOnClickListener(this);

        school.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        if(v.getId()==R.id.schoolclg)
        {
             intent = new Intent(MainActivity.this,SchoolClg.class);
             intent.putExtra("key","book");
             startActivity(intent);


        }

        else if(v.getId()==R.id.islamic)
        {
            intent = new Intent(MainActivity.this,IslamiBook.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }

        else if(v.getId()==R.id.programming)
        {
            intent = new Intent(MainActivity.this,Programming.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }


        else if(v.getId()==R.id.Liberation)
        {
            intent = new Intent(MainActivity.this,Liberation.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }

        else if(v.getId()==R.id.story)
        {
            intent = new Intent(MainActivity.this,Story.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }
        else if(v.getId()==R.id.admission)
        {
            intent = new Intent(MainActivity.this,Admission.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }



        else if(v.getId()==R.id.medical)
        {
            intent = new Intent(MainActivity.this,Medical.class);
            intent.putExtra("key","book");
            startActivity(intent);


        }


    }

    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog.Builder alert;

        alert = new AlertDialog.Builder(MainActivity.this);

        alert.setIcon(R.drawable.exiticon);

        alert.setMessage(R.string.exit);

        alert.setTitle(R.string.title);

        alert.setCancelable(false);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alert.create();

        alertDialog.show();

    }
}
