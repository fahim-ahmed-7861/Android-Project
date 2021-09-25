package com.example.asus.mysqlitedatabasedemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

public class MyDatabaseHelper  extends SQLiteOpenHelper {

    private static  final String Datbase_Name = "Student.db";

    private static  final String Table_Name = "student_details";

    private static  final  int version_num = 3;

    private static  final String ID = "_id";

    private static  final String Name = "Name";

    private static  final  String Age= "Age";

    private  static  final String Gender = "Gender";

    private  static  final  String  Create_Table = "CREATE TABLE "+Table_Name+"( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+Name+" VARCHAR(256),"+Age+" INTEGER , "+Gender + " VARCHAR(15) );";

    private static  final String Drop_Table = "DROP TABLE IF EXISTS "+Table_Name;

    private  static  final  String Select_query="SELECT * FROM "+Table_Name;
    private Context context;
    public MyDatabaseHelper(Context context) {

        super(context, Datbase_Name, null, version_num);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       try
       {
           db.execSQL(Create_Table);

           Toast.makeText(context,"Oncreate Is Created ",Toast.LENGTH_LONG).show();
       }catch (Exception e )
       {
           Toast.makeText(context,"Exception "+e,Toast.LENGTH_LONG).show();
       }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Toast.makeText(context,"OnUpgrade Method is called ",Toast.LENGTH_LONG).show();

            db.execSQL(Drop_Table);

            onCreate(db);


        }catch (Exception e)
        {
            Toast.makeText(context,"Exception "+e,Toast.LENGTH_LONG).show();
        }

    }
    public long InsertDate(String ID,String Name,String Age,String Gender)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put("_id",ID);

        values.put("Name",Name);

        values.put("Age",Age);

        values.put("Gender",Gender);

        long rowid=sqLiteDatabase.insert(Table_Name,null,values);


        return rowid;




    }

    public Cursor DisplayDataSet()
    {
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

       Cursor cursor =sqLiteDatabase.rawQuery(Select_query,null);

       return cursor;
    }

}
