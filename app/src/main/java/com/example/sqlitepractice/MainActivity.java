package com.example.sqlitepractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Dbclass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        db = new Dbclass(this);
    }

    public void btnclick(View view) {
        String uname = ed1.getText().toString();
        String uemail = ed2.getText().toString();
        String upswd = ed3.getText().toString();
        String cpswd = ed4.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are you Sure You Want to Save Data?");
        alert.setTitle("Confirmation");
        alert.setIcon(R.drawable.ic_baseline_admin_panel_settings_24);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (uname.isEmpty()) {
                    ed1.requestFocus();
                    ed1.setError("*");
                } else if (uemail.isEmpty()) {
                    ed2.requestFocus();
                    ed2.setError("*");
                } else if (upswd.isEmpty()) {
                    ed3.requestFocus();
                    ed3.setError("*");
                } else {
                    if (upswd.equals(cpswd)) {
                        boolean emailexist = db.emailexists(uemail);
                        if (emailexist == true) {
                            Toast.makeText(MainActivity.this, "Email Exist", Toast.LENGTH_SHORT).show();
                        } else {


                            boolean res = db.insertdata(uname, uemail, upswd);
                            if (res == true) {
                                Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, "Data Not Saved Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Password Do not Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();


    }

    public void go(View view)
    {
        Intent i =new Intent(this,MainActivity2.class);
        startActivity(i);
        finish();
    }
}