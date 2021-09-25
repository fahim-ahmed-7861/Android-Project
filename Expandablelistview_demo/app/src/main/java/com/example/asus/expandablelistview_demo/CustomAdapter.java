package com.example.asus.expandablelistview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {

    Context context ;


    List<String> listdataheader;

    HashMap<String,List<String>> lisdatachild;


    @Override
    public int getGroupCount() {
        return listdataheader.size();
    }

    public CustomAdapter(Context context, List<String> listdataheader, HashMap<String, List<String>> lisdatachild) {
        this.context = context;
        this.listdataheader = listdataheader;
        this.lisdatachild = lisdatachild;
    }

    @Override
    public int getChildrenCount(int groupPosition) {



        return lisdatachild.get(listdataheader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listdataheader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return lisdatachild.get(listdataheader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headertext= (String) getGroup(groupPosition);

        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView=inflater.inflate(R.layout.group_layout,null);


        }

        TextView textView=convertView.findViewById(R.id.gtextid);

        textView.setText(headertext);




        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String childtext= (String) getChild(groupPosition,childPosition);

        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView=inflater.inflate(R.layout.child_layout,null);


        }

        TextView textView=convertView.findViewById(R.id.ctextid);

        textView.setText(childtext);




        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
