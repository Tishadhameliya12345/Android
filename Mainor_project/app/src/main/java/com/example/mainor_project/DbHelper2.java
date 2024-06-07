package com.example.mainor_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper2 extends SQLiteOpenHelper {
    public static final String dbname="details.db";

    public DbHelper2(Context context) {
        super(context, "details.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table fdetail(dname Text primary key,phno Text,plocation Text,fitem Text,ptime Text,pday date,quntity Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists fdetail");
    }

    public Boolean insertdata(String dname,String phno,String plocation,String fitem,String ptime,String pday,String quntity){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("dname",dname);
        contentValues.put("phno",phno);
        contentValues.put("plocation",plocation);
        contentValues.put("fitem",fitem);
        contentValues.put("ptime",ptime);
        contentValues.put("pday",pday);
        contentValues.put("quntity",quntity);
        long result=MyDB.insert("fdetail",null,contentValues);
        if(result==-1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from fdetail",null);
        return cursor;
    }
}
