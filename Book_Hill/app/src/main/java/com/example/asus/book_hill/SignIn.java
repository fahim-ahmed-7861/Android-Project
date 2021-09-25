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

public class SignIn extends AppCompatActivity {


    private Button login;
    private EditText email,pass;
    private AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);



        this.setTitle("           Sign In");

        login = findViewById(R.id.login);

       email = findViewById(R.id.e1);

       pass = findViewById(R.id.e2);

       final String admin ="shojiblm6@gmail.com";

       final String adminpass = "2018";


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if(v.getId()==R.id.login)
                    {
                        if(email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                            alert = new AlertDialog.Builder(SignIn.this);

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
                        else if (admin.equals(email.getText().toString()) && adminpass.equals(pass.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_LONG).show();


                            pass.setText("");

                            Intent intent= new Intent(getApplicationContext(),Booksection.class);
                            startActivity(intent);
                        }

                        else if (SignUp.register.get(email.getText().toString()).equals(pass.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_LONG).show();


                            pass.setText("");

                            Intent intent= new Intent(getApplicationContext(),Booksection.class);
                            startActivity(intent);
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(),"You input wrong email or password,  please try again !",Toast.LENGTH_LONG).show();
                        }
                    }

                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Please Signup first",Toast.LENGTH_LONG).show();
                }



            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

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
