package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText ed1,ed2;
    Button btn;
    Dbclass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1 = (EditText) findViewById(R.id.ed12);
        ed2 = (EditText) findViewById(R.id.ed22);
        btn = (Button) findViewById(R.id.button2);
        db = new Dbclass(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1 = ed1.getText().toString();
                String txt2 = ed2.getText().toString();

                boolean res = db.login(txt1,txt2);
                if (res == true){
                    Toast.makeText(MainActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(MainActivity2.this,ShowRecords.class);
                    SharedPreferences dh = getSharedPreferences("abc",MODE_PRIVATE);
                    SharedPreferences.Editor ed = dh.edit();
                    ed.putString("Name",txt1);
                    ed.apply();
                    startActivity(i);
                }
                else if(txt1.equals("Admin2gmail.com") && txt2.equals("123"))
                {
                    Toast.makeText(MainActivity2.this, "Login Admin", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(MainActivity2.this,Dashboard.class);
                    SharedPreferences dh = getSharedPreferences("abc",MODE_PRIVATE);
                    SharedPreferences.Editor ed = dh.edit();
                    ed.putString("Name","Admin");
                    ed.apply();
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity2.this, "Login Not Successful", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void go2(View view)
    {
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}