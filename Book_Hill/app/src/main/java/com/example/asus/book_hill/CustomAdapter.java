package com.example.asus.book_hill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {


   private Context context ;

    private  String[] book,price;

    private  int[] picture;

   private LayoutInflater inflater;

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


            convertView=inflater.inflate(R.layout.sample_view,parent,false);
        }

        ImageView imageView =convertView.findViewById(R.id.layoutimage);

        TextView textViewtk = convertView.findViewById(R.id.layouttk);


        TextView textViewbook =convertView.findViewById(R.id.layoutbookname);

        imageView.setImageResource(picture[position]);

        textViewtk.setText(price[position]);

        textViewbook.setText(book[position]);



        return convertView;
    }
}
