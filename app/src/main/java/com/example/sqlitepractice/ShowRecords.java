package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowRecords extends AppCompatActivity {
ListView ls;
EditText ed;
Dbclass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ed = (EditText) findViewById(R.id.editText222);
        setContentView(R.layout.activity_show_records);
        ls = (ListView) findViewById(R.id.list);
        db = new Dbclass(this);
        ArrayList<HashMap<String,String>> record = db.Show();
        ListAdapter adpt = new SimpleAdapter(this,record,R.layout.layoutwalifile,new String[]{"Name","Email"},new int[]{R.id.uname,R.id.uemail});
        ls.setAdapter(adpt);
    }
    public void btn(View view)
    {
        int id = Integer.parseInt(ed.getText().toString());
        boolean res = db.deleterecord(id);
        if (res == true)
        {
            Toast.makeText(ShowRecords.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(ShowRecords.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}