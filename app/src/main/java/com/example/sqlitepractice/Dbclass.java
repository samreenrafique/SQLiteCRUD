package com.example.sqlitepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class Dbclass extends SQLiteOpenHelper {
    public String dbname = "Registerdb.db";
    public Dbclass(Context context) {
        super(context, "Registerdb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table singup(Id integer primary key autoincrement, username text, useremail text, userpswd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists signup");
    }
    public boolean insertdata(String u , String e , String p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("username",u);
        data.put("useremail",e);
        data.put("userpswd",p);
        long result = db.insert("singup",null, data);
        if (result > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean emailexists(String e){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from singup where useremail = ?",new String[]{e});
        if (c.getCount() > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean login(String n ,String p){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from singup where useremail = ? and userpswd = ?",new String[]{n,p});
        if (c.getCount() > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public ArrayList<HashMap<String,String>> GetUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select username,useremail from singup",null);
        ArrayList<HashMap<String,String>> userlist = new ArrayList<>();
        while (cursor.moveToNext())
        {
            HashMap<String,String> user = new HashMap<>();
            user.put("Name",cursor.getString(0));
            user.put("Email",cursor.getString(1));
            userlist.add(user);
        }
        return userlist;
    }

    public ArrayList<HashMap<String,String>> Show(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select Id,username,useremail from singup",null);
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        while(c.moveToNext()){
            HashMap<String,String> item = new HashMap<>();
            item.put("Name",c.getString(0));
            item.put("Email",c.getString(1));
            list.add(item);
        }
        return list;
    }
    public Cursor fetchdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from singup",null);
        return c;
    }
    public boolean deleterecord(int id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        int a = db.delete("signup","Id = ?",new String[]{String.valueOf(id)});
        if (a > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
