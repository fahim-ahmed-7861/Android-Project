package com.example.asus.book_hill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Customorder extends BaseAdapter {

    private  Context context ;

    private  String[] book,price;



    //private ListView listView;



    LayoutInflater inflater;

    public Customorder(Context context, String[] book, String[] price) {
        this.context = context;
        this.book = book;
        this.price = price;

    }


    @Override
    public int getCount() {
        return book.length;
    }

    @Override
    public Object getItem(int position) {
        return book[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


            convertView=inflater.inflate(R.layout.sample_order,parent,false);
        }



        TextView textViewtk = convertView.findViewById(R.id.layouttko);


        TextView textViewbook =convertView.findViewById(R.id.layoutbooknameo);



        textViewtk.setText(price[position]);

        textViewbook.setText(book[position]);



        return convertView;
    }
}
