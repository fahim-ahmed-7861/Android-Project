package com.example.asus.mysqlitedatabasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyDatabaseHelper myDatabaseHelper ;

    private EditText id,gender,name,age;

    private Button Addbutton,Clearbutton,ShowData,Update,Delete;

    private  String Name,Id,Gender,Age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this);

        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        FINDId();

        Addbutton.setOnClickListener(this);

        Clearbutton.setOnClickListener(this);

        ShowData.setOnClickListener(this);

        Update.setOnClickListener(this);

        Delete.setOnClickListener(this);

    }

    private void FINDId()
    {
        id=findViewById(R.id.id);

        gender=findViewById(R.id.Gender);

        name=findViewById(R.id.name);

        age=findViewById(R.id.Age);

        Addbutton=findViewById(R.id.addButton);

        Clearbutton=findViewById(R.id.ClearButton);

        ShowData=findViewById(R.id.ShowButton);

        Update=findViewById(R.id.UpdateButton);
    }
    private void GetEditText()
    {
        Name=name.getText().toString();

        Id=id.getText().toString();

        Age=age.getText().toString();

        Gender=gender.getText().toString();
    }

    @Override
    public void onClick(View v) {

       GetEditText();


        if(v.getId()==R.id.addButton)
        {
            long rowid=myDatabaseHelper.InsertDate(Id,Name,Age,Gender);


            if(rowid==-1)
                Toast.makeText(MainActivity.this,"Unsucessfully Inserted",Toast.LENGTH_LONG).show();

            else
                Toast.makeText(MainActivity.this,"Sucessfully Inserted Row :"+rowid,Toast.LENGTH_LONG).show();

        }
        else if(v.getId()==R.id.ClearButton)
        {
            name.setText("");
            id.setText("");
            gender.setText("");
            age.setText("");
        }
        else if(v.getId()==R.id.ShowButton)
        {
            Cursor cursor = myDatabaseHelper.DisplayDataSet();

            if(cursor.getCount()==0)
            {
                 ShowDataSET("Error","No Data Found");
                return ;
            }

            StringBuffer stringBuffer=new StringBuffer();

            while (cursor.moveToNext())
            {
                stringBuffer.append("  ID   :"+cursor.getString(0)+"\n");

                stringBuffer.append(" Name  :"+cursor.getString(1)+"\n");

                stringBuffer.append(" Age   :"+cursor.getString(2)+"\n");

                stringBuffer.append("Gender :"+cursor.getString(3)+"\n\n");

            }

            ShowDataSET("ResultSet ",stringBuffer.toString());
        }
        else if(v.getId()==R.id.UpdateButton)
        {

        }
    }

    public void ShowDataSET(String title,String resultset)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);

        builder.setMessage(resultset);

        builder.setCancelable(true);

        builder.show();


    }


}
