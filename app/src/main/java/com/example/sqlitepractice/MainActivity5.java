package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    ListView ls;
    final ArrayList<singup> data=  new ArrayList<singup>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ls = (ListView) (findViewById(R.id.listmm));
        Dbclass db = new Dbclass(this);
        Cursor record = db.fetchdata();
        ls.setAdapter(null);
        data.clear();
        if (record.getCount() == 0)
        {
            Toast.makeText(this, "No Record Found", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (record.moveToNext()) {
                @SuppressLint("Range") String id_val = record.getString(record.getColumnIndex("Id"));
                @SuppressLint("Range") String name_val = record.getString(record.getColumnIndex("username"));
                @SuppressLint("Range") String email_val = record.getString(record.getColumnIndex("useremail"));

                data.add(new singup(id_val, name_val, email_val));
                Log.d("Id",id_val);
            }
             Log.d("Data",String.valueOf(data));
            helper r1 = new helper(this, data);
            ls.setAdapter(r1);
        }
    }
}