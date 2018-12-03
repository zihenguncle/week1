package com.bwie.guoziheng.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bwie.guoziheng.sqlite.MySqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class DataDao {

    public SQLiteDatabase base;

    public DataDao(Context context){
        MySqliteHelper mySqliteHelper = new MySqliteHelper(context);
        base = mySqliteHelper.getReadableDatabase();
    }

    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        base.insert("data",null,values);
    }
    public List<String> select(){
        List<String> list = new ArrayList<>();
        Cursor query = base.query("data", null, null, null, null, null, null);
        while (query.moveToNext()){
            String name = query.getString(query.getColumnIndex("name"));
            list.add(name);
        }
        return list;
    }
    public void addtwo(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        base.insert("datatwo",null,values);
    }

    public void delall(){
        base.delete("data",null,null);
    }

}
