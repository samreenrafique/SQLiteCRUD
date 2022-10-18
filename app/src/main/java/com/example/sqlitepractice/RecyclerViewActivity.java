package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rec;
    ArrayList<singup> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rec = (RecyclerView) findViewById(R.id.myrecycle);
        rec.setLayoutManager(new LinearLayoutManager(this));
        arr = new ArrayList<>();

        Dbclass db = new Dbclass(this);
        Cursor c = db.fetchdata();
        if (c.getCount() == 0)
        {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
            Log.d("Msg","No Data");
        }
        else{
            while(c.moveToNext())
            {
                String id = c.getString(0);
                String name = c.getString(1);
                String email = c.getString(2);
                singup s = new singup(id,name,email);
                arr.add(s);
                Log.d("Data",id);
            }
            adapterforrecycle recy = new adapterforrecycle(arr);
            rec.setAdapter(recy);
        }
    }
}