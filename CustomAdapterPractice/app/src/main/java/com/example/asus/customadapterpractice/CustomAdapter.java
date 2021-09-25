package com.example.asus.customadapterpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    int[] flags;

    String[] county_name;

    Context context;



    private  LayoutInflater inflater;

    CustomAdapter(Context context, String[] county_name,int[] flags )
    {
        this.context=context;

       this.county_name=county_name;

        this.flags=flags;

    }

    @Override
    public int getCount() {
        return county_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null) {
          //  inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


           // convertView=inflater.inflate(R.layout.sample_view, parent, false);

            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


            convertView=inflater.inflate(R.layout.sample_view,parent,false);

        }

        ImageView imageView=convertView.findViewById(R.id.imageid);

        TextView textView = convertView.findViewById(R.id.textid);

        imageView.setImageResource(flags[position]);

        textView.setText(county_name[position]);



        return convertView;
    }



}
