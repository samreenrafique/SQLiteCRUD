package com.example.sqlitepractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed1 = (EditText) findViewById(R.id.editTextTextPersonName);
        ed2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        ed3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity3.this);
                alert.setTitle("Alert Dialog");
                alert.setIcon(R.drawable.ic_baseline_admin_panel_settings_24);
                alert.setMessage("Are you Sure You want to add Data ? ");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity3.this, "Positive Button", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity3.this, "Negative Button", Toast.LENGTH_SHORT).show();

                    }
                });
                alert.show();
            }
        });
    }
}