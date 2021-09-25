package com.example.asus.testcheckbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

  Context context ;

  String[] book,price;

  int[] picture;

  LayoutInflater inflater;

    public CustomAdapter(Context context, String[] book, String[] price, int[] picture) {
        this.context = context;
        this.book = book;
        this.price = price;
        this.picture = picture;
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


            convertView=inflater.inflate(R.layout.sample_layout,parent,false);
        }

        ImageView imageView =convertView.findViewById(R.id.iid);

        TextView textView = convertView.findViewById(R.id.tid);


        TextView checkBox =convertView.findViewById(R.id.cid);

        imageView.setImageResource(picture[position]);

        textView.setText(price[position]);

        checkBox.setText(book[position]);



        return convertView;
    }
}
