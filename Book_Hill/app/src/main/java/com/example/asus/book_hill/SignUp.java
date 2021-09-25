package com.example.asus.book_hill;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    private Button signup;
    private EditText user,pass,confirm,email;

   static  HashMap<String,String> register = new HashMap<String, String>();

    ArrayList<String> repeat= new ArrayList<String>();

    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        findID();

        this.setTitle("           Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.signup)
                {
                    if(email.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || user.getText().toString().isEmpty()||confirm.getText().toString().isEmpty()) {
                        alert = new AlertDialog.Builder(SignUp.this);

                        alert.setIcon(R.drawable.question);

                        alert.setMessage("Please fill up the all field !");

                        alert.setTitle("Alert");

                        alert.setCancelable(false);

                        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });


                        AlertDialog alertDialog = alert.create();

                        alertDialog.show();

                    }
                    else if(email.getText().toString().indexOf("@gmail.com")==-1 && email.getText().toString().indexOf("@yahoo.com")==-1)
                    {
                        alert = new AlertDialog.Builder(SignUp.this);

                        alert.setIcon(R.drawable.question);

                        alert.setMessage("Wrong Email Addrees!");

                        alert.setTitle("Alert");

                        alert.setCancelable(false);

                        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });


                        AlertDialog alertDialog = alert.create();

                        alertDialog.show();
                    }


                    else if(!pass.getText().toString().equals(confirm.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Password & Confirm password are not match !",Toast.LENGTH_LONG).show();
                    }
                    else if(repeat.contains(email.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"This email already have account !",Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                         register.put(email.getText().toString(),pass.getText().toString());

                         repeat.add(email.getText().toString());

                        Toast.makeText(getApplicationContext(),"Successfully register !",Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(),SignIn.class);
                        //intent.putExtra("key","book");
                        startActivity(intent);


                    }
                }

            }
        });

    }

    private void findID()
    {
        user =findViewById(R.id.user);

        email = findViewById(R.id.email);

        confirm = findViewById(R.id.confirm);

        pass = findViewById(R.id.pass);

        signup  =findViewById(R.id.signup);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {

    }
}
