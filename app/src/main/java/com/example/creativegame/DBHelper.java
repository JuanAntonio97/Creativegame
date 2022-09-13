package com.example.creativegame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "register.db";
    public DBHelper(Context context){
        super(context, "register.db",  null, 1);


    }
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table person(username TEXT , name TEXT primary key, password TEXT, repassword TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1 ) {

        MyDB.execSQL("drop Table if exists person");

    }
    public Boolean insertData(String name,String username, String password, String repassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("repassword",repassword);

        long result = MyDB.insert("person",null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkaadhar(String username){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where username = ?",new String[]{username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
