package com.example.sqlitepractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterforrecycle extends RecyclerView.Adapter<adapterforrecycle.viewholder>{
    ArrayList<singup> a;

    public adapterforrecycle(ArrayList<singup> a) {
        this.a = a;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardprototype,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.i.setText(a.get(position).getId());
        holder.n.setText(a.get(position).getUsername());
        holder.e.setText(a.get(position).getUseremail());
    }

    @Override
    public int getItemCount() {
        return a.size();
    }

    class viewholder extends RecyclerView.ViewHolder{

        TextView i,n,e;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            i = (TextView) itemView.findViewById(R.id.cuserid);
            n = (TextView) itemView.findViewById(R.id.cusername);
            e = (TextView) itemView.findViewById(R.id.cuseremail);
        }
    }
}
