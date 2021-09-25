package com.example.asus.spinnerwithonitemselected;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;

    private String[] countryname,population;

    private int[] flags ;

    private LayoutInflater inflater;

    public CustomAdapter(Context context, String[] countryname, String[] population, int[] flags) {
        this.context = context;
        this.countryname = countryname;
        this.population = population;
        this.flags = flags;
    }

    @Override
    public int getCount() {
        return countryname.length;
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

        if(convertView==null)
        {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


            convertView = inflater.inflate(R.layout.sample_layout,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageid);

        TextView textView1 = convertView.findViewById(R.id.countrylayoutid);

        TextView textView2 = convertView.findViewById(R.id.populationid);

        imageView.setImageResource(flags[position]);

        textView1.setText(countryname[position]);

        textView2.setText(population[position]);



        return convertView;
    }
}
