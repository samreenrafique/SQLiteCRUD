package com.example.sqlitepractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class helper extends BaseAdapter {
    Context c;
    ArrayList<singup> arr;
    LayoutInflater lay;

    public helper(Context c, ArrayList<singup> arr) {
        this.c = c;
        this.arr = arr;
        this.lay = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return 0;
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
        convertView = lay.inflate(R.layout.tablelayout,null);
        TextView txt1 = convertView.findViewById(R.id.id);
        TextView txt2 = convertView.findViewById(R.id.name);
        TextView txt3 = convertView.findViewById(R.id.email);

        singup st = arr.get(position);
        txt1.setText(st.getId());
        txt2.setText(st.getUsername());
        txt3.setText(st.getUseremail());
        return convertView;
    }
}
