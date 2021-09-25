package com.example.asus.searchviewtest;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Aadapter extends BaseAdapter implements Filterable {

    Context c;

    ArrayList<player>players,filterlist;

    CustomFilter filter;



    public Aadapter(Context c, ArrayList<player> players) {
        this.c = c;
        this.players = players;

        this.filterlist=players;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int position) {
        return players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return players.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,null);
        }

        TextView textView = convertView.findViewById(R.id.cid);

        ImageView image = convertView.findViewById(R.id.iid);

        textView.setText(players.get(position).getName());

        image.setImageResource(players.get(position).getImg());
        return convertView;
    }

    public Filter getFilter()
    {
        if(filter==null)
        {
            filter = new CustomFilter();


        }


            return filter;
    }

    class CustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if(constraint!=null && constraint.length()>0)
            {
                constraint=constraint.toString().toUpperCase();

                ArrayList<player>filters = new ArrayList<player>();

                for(int i =0 ; i<filterlist.size(); i++)
                {
                    if(filterlist.get(i).getName().toUpperCase().contains(constraint))
                    {
                        player player = new player(filterlist.get(i).getName(),filterlist.get(i).getImg());

                        filters.add(player);
                    }
                }

                results.count=filters.size();

                results.values=filters;



            }

            else

            {
                results.count=filterlist.size();

                results.values=filterlist;
            }


            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            players = (ArrayList<player>) results.values;

            notifyDataSetChanged();

        }
    }
}
