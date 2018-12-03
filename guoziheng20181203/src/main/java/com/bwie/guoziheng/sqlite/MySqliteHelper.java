package com.bwie.guoziheng.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MySqliteHelper extends SQLiteOpenHelper {
    public MySqliteHelper(@Nullable Context context) {
        super(context, "data_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table data(id integer primary key autoincrement," +
                "name text)");
        db.execSQL("create table datatwo(id integer primary key autoincrement," +
                "name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
