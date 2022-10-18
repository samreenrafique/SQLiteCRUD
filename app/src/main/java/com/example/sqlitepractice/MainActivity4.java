package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Dbclass db = new Dbclass(this);
        ArrayList<HashMap<String,String>> userlist = db.GetUser();
        ls = (ListView) findViewById(R.id.listview);
        ListAdapter adpt = new SimpleAdapter(this,userlist,R.layout.nestedlayout,
	new String[]{"Name","Email"},new int[]{R.id.uname,R.id.uemail});
        ls.setAdapter(adpt);
        ls.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(MainActivity4.this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}