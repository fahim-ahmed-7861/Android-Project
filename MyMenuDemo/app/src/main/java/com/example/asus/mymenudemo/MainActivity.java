package com.example.asus.mymenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu_layout,menu);



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.seetingid)
        {
            Toast.makeText(MainActivity.this,"Setting",Toast.LENGTH_SHORT).show();

            return true;
        }

        else if(item.getItemId()==R.id.feedbackid) {
            Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
             return true;
        }

        else if(item.getItemId()==R.id.aboutusid) {
            Toast.makeText(MainActivity.this, "About us", Toast.LENGTH_SHORT).show();

            return true;

        }

        else if(item.getItemId()==R.id.shareid) {
            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();

            return true;

        }


        return super.onOptionsItemSelected(item);
    }
}
