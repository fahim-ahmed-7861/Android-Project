package com.example.asus.expandablelistview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    List<String> listdataheader;

    private CustomAdapter customAdapter;

    public  int i;


    HashMap<String,List<String>>lisdatachild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preparelisdata();

        expandableListView = findViewById(R.id.expandable);

        customAdapter = new CustomAdapter(this,listdataheader,lisdatachild);


        expandableListView.setAdapter(customAdapter);

    }

    public void preparelisdata()
    {

        String[] header = getResources().getStringArray(R.array.parent_name);

        String[] child= getResources().getStringArray(R.array.child_name);

        lisdatachild =new HashMap<>();

        listdataheader = new ArrayList<>();

        for(int i =0; i<header.length; i++)
        {
           listdataheader.add(header[i]);

           List<String> ans =  new ArrayList<>();

           ans.add(child[i]);

           lisdatachild.put(listdataheader.get(i),ans);
        }


    }

}
