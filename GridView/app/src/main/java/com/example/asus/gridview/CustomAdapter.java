package com.example.asus.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    String[] countryname;

    int[] flags;

    Context context;

    private LayoutInflater inflater;

    CustomAdapter(Context context,String[] countryname,int[] flags)
    {
        this.context=context;

        this.countryname=countryname;

        this.flags=flags;
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

            convertView=inflater.inflate(R.layout.sample_view,parent,false);
       }
        ImageView imageView = convertView.findViewById(R.id.imageid);

        TextView textView = convertView.findViewById(R.id.textid);

        imageView.setImageResource(flags[position]);

        textView.setText(countryname[position]);


        return convertView;
    }
}
